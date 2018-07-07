const Film = require('../models/Film');

module.exports = {

	index: (req, res) => {
		Film.find().then(films => {
            res.render('film/index', {films: films});
        });
	},

	createGet: (req, res) => {
		return res.render('film/create');
	},

	createPost: (req, res) => {

		let film = req.body;

		if(film.genre === "" || film.director === "" || film.year === "")
		{
			res.redirect('/create');
            return;
        }

		Film.create(film).then(film => {
            res.redirect('/');
        })
	},

	editGet: (req, res) => {

		let id = req.params.id;

        Film.findById(id).then(film => {

        	if(!film)
			{
				res.redirect('/');
				return;
			}

		    res.render('film/edit',film);
		})

	},

	editPost: (req, res) => {

        let id = req.params.id;

        let filmChanged = req.body;

        if(filmChanged.genre === "" || filmChanged.director === "" || filmChanged.year === "")
		{
            Film.findById(id).then(film => {

                if(!film)
                {
                    res.redirect('/');
                    return;
                }
                res.render('film/edit',film);
    		});
		}

        Film.findByIdAndUpdate(id, filmChanged , {runValidators:true})
            .then( film => {
                res.redirect('/');
            });

	},

	deleteGet: (req, res) => {

	    let id = req.params.id;

        Film.findById(id).then(film => {

            if(!film)
            {
                res.redirect('/');
                return;
            }

            res.render('film/delete' +
				'',film);
        })

    },

	deletePost: (req, res) => {

        let id = req.params.id;

        Film.findByIdAndRemove(id).then(film => {
			res.redirect('/');
        });

    }
};
