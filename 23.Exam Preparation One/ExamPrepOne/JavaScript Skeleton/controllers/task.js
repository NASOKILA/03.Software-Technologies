const Task = require('../models/Task');
// Task modela veche nie e importiran avtomatichno

module.exports = {
    index: (req, res) => {

        //TODO: Implement me...

    	// Trqbva da vzemem vsichki taskove ot bazata i da gi podadem na inde viewto
		    	Task.find().then(tasks => {
            res.render('task/index', {'tasks': tasks});
		});


    },

	createGet: (req, res) => {

        //TODO: Implement me...
		// Tuk prosto vrushtame create viewto
		return res.render('task/create');
	},

	createPost: (req, res) => {
        //TODO: Implement me...


		// KATO DEBUGVAME VIJDAME KAKVO POLUCHAVAME OT FORMATA I CHE MOJEM DA DA GO VZEMEM OT req.body
		// VZIMAME SI TASKA
		let task = req.body;

		if(task.title === "" || task.comments === "")
		{
			//Ako title ili comments sa prazni, vrushtame usera kum create stranivcata
			res.redirect('/create');
            return;
        }

		//Ako taska nqma prazni poleta
		// ZAPISVAME GO V BAZATA:

		Task.create(task).then(task => {
			res.redirect('/');
		})


	},

	deleteGet: (req, res) => {

        //TODO: Implement me...

		//1. VZIMAME SI ID-to OT URL-a
        // KATO DEBUGVAME VIJDAME CHE ID-to SE SUDURJA V req.params
        let id = req.params.id;

		//2. Namirame taska s tova id
		Task.findById(id).then( task => {

			//Ako nqma takuv task se vrushtame kum index viewto
			if(!task)
			{
                res.redirect('/');
                return;
			}

			// ako ima takuv task go podavame na delete viewto
			res.render('task/delete',task);
			// PISHEM SAMO task VMESKO {'task' : task} ZASHTOTO TAKA GO ISKA VIEWTO
			//VINAGI PROVERQVAI VIEWTATA
		});


	},

	deletePost: (req, res) => {

    	//TODO: Implement me...

		//1. Vzimam si IDto
		let id = req.params.id;

		//2. TRIEM TASKA
		Task.findById(id).then(task => {

            // AKO SUSHTESTVUVA TAKUV TASK GO TRIEM :
            Task.remove(task).then(task => {
				res.redirect('/');
			});

            // IMAME I METOD findByIdAndRemove() KOITO SHTE IZPULNI TOVA AVTOMATICHNO


        });
	}
};