const Task = require('../models/Task');

module.exports = {

	index: (req, res) => {

		let taskPromisesArray =
			[
				Task.find({status: "Open"}),
				Task.find({status: "In Progress"}),
				Task.find({status: "Finished"})
			];
		Promise.all(taskPromisesArray).then( tasks => {
			res.render('task/index', {

				'openTasks': tasks[0],
                'inProgressTasks': tasks[1],
                'finishedTasks': tasks[2],

			});
		});
	},

	createGet: (req, res) => {

        return res.render('task/create');
	},

	createPost: (req, res) => {

		let task = req.body;

		if(task.title === "")
		{
			res.render('/');
			return;
		}

		Task.create(task).then(task => {
			res.redirect('/');
		});
	},

	editGet: (req, res) => {

		let id = req.params.id;
		
		Task.findById(id).then(task => {

			if(!task)
			{
				res.redirect('/');
				return;
			}

            res.render('task/edit', task);
		});
	},

	editPost: (req, res) => {

		let id = req.params.id;

		let taskChanged = req.body;

		Task.findByIdAndUpdate(id, taskChanged , {runValidators:true})
			.then( tasks => {
				res.redirect('/');
		});
	}
};