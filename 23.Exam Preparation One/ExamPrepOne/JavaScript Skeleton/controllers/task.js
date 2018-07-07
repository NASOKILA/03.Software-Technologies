const Task = require('../models/Task');

module.exports = {
    index: (req, res) => {
		    Task.find().then(tasks => {
            res.render('task/index', {'tasks': tasks});
		});


    },

	createGet: (req, res) => {
		return res.render('task/create');
	},

	createPost: (req, res) => {

		let task = req.body;

		if(task.title === "" || task.comments === "")
		{
			res.redirect('/create');
            return;
        }

		Task.create(task).then(task => {
			res.redirect('/');
		})
	},

	deleteGet: (req, res) => {

        let id = req.params.id;

		Task.findById(id).then( task => {

			if(!task)
			{
                res.redirect('/');
                return;
			}

			res.render('task/delete',task);
		});
	},

	deletePost: (req, res) => {
		
		let id = req.params.id;

		Task.findById(id).then(task => {

            Task.remove(task).then(task => {
				res.redirect('/');
			});
        });
	}
};