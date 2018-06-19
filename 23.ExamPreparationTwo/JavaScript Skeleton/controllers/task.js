const Task = require('../models/Task');

module.exports = {

	index: (req, res) => {

		// TRQBVA DA PODADEM NA VIEWTO TRITE KOLEKCII OT TASKOVE

		// PRAVIM SI MASIV OT ZAQVKI ZA DA GI PODADEM NA VIETO NA VEDNUJ INACHE DAVA GRESHKA !!!
		let taskPromisesArray =
			[
				Task.find({status: "Open"}),
				Task.find({status: "In Progress"}),
				Task.find({status: "Finished"})
			];

		// KAZVAM CHE KOGATO VSICHKI TEZI taskPromesi SA ZAVURSHILI EDNOVREMENNO
		// I POSLE VECHE SLAGAME .then
		Promise.all(taskPromisesArray).then( tasks => {
			res.render('task/index', {
                // Otvorenite sa na poziciq tasks[0], a drugite sa na tasks[1] i tasks[2]
                'openTasks': tasks[0],
                'inProgressTasks': tasks[1],
                'finishedTasks': tasks[2],

			});
		});

		/*
		 Ima po lesen nachin :


		  Task.find().then( tasks => {
		      res.render('task/index', {
		         'openTasks': tasks.filter(t => t.status === "Open"),
		         'inProgressTasks': tasks.filter(t => t.status === "In Progress"),
		         'finishedTasks': tasks.filter(t => t.status === "Finished")
		      });
		  });

		 */

	},

	createGet: (req, res) => {

        // Tuk prosto vrushtame create viewto
        return res.render('task/create');
	},

	createPost: (req, res) => {

		// vzimame si taska ot formata
		let task = req.body;

		// Ako ima prazvni poleta se vrushtame kum create viewto
		if(task.title === "")
		{
			res.render('/');
			return;
		}
		//Ako nqma prazni poleta seivame v bazata polucheniq task
		Task.create(task).then(task => {
			res.redirect('/');
		});

	},

	editGet: (req, res) => {

		//vzimame id-to
		let id = req.params.id;



		Task.findById(id).then(task => {

			if(!task)
			{
				// ako nqma takuv task se vrushtame v glavnata stranice
				res.redirect('/');
				return;
			}

            //prosto pokazvame viewto
            res.render('task/edit', task);

		});


	},

	editPost: (req, res) => {

		// vzimame id-to
		let id = req.params.id;

		//vzimame si novite stoinosti
		let taskChanged = req.body;

		//S findByIdAndUpdate() namirame po id i updatevame namernoto s taskChanged
		// KAZVAME DUN VALIDATORS:TRUE ZASHTOTO NE GI PUSKA I MOJEM DA ZAPISHEM TASK BES TITLE !!!
		Task.findByIdAndUpdate(id, taskChanged , {runValidators:true})
			.then( tasks => {
				res.redirect('/');
		});

	}
};