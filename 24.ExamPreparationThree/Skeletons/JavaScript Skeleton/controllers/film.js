const Film = require('../models/Film');

module.exports = {

	index: (req, res) => {

        // Trqbva da vzemem vsichki filmi ot bazata i da gi podadem na index viewto

		Film.find().then(films => {
            res.render('film/index', {films: films});
        });

	},

	createGet: (req, res) => {
		//Vrushtame create viewto
		return res.render('film/create');
	},

	createPost: (req, res) => {

		// Vzimame si filma ot formata
		let film = req.body;

		//TOVA MOJE I DA NE GO PISHEM NA IZPITA
		//proverqvame dali e validen
		if(film.genre === "" || film.director === "" || film.year === "")
		{
			// Ako ne sa validni dannite se vrushtame kum sustata stranica
			res.redirect('/create');
            return;
        }

		// zapazvame go v bzata i redirektvame kum '/'
		Film.create(film).then(film => {
            res.redirect('/');
        })
	},

	editGet: (req, res) => {

		// vzimame id-to
		let id = req.params.id;

        //namirame filma s tova id i go vrushtame na viewto
        Film.findById(id).then(film => {

        	// TOVA MOJEM I DA NE GO PISHEM NA IZPITA
			//proverqvame dali filma sushtestvuva
			if(!film)
			{
				res.redirect('/');
				return;
			}

			// podavame go na viewto
			res.render('film/edit',film);
		})

	},

	editPost: (req, res) => {

		// Vzimame ID-to
        let id = req.params.id;

        // Vzimame si i novite stoinosti
        let filmChanged = req.body;

        //Ako promenite NE sa validni
        if(filmChanged.genre === "" || filmChanged.director === "" || filmChanged.year === "")
		{
			// SE VRUSHTAME NA SUTHTATA STRANICA
            Film.findById(id).then(film => {

                // TOVA MOJEM I DA NE GO PISHEM NA IZPITA
                //proverqvame dali filma sushtestvuva
                if(!film)
                {
                    res.redirect('/');
                    return;
                }
                res.render('film/edit',film);
		});
		}

        //Namirame filma koito shte promenim po id i go zamestvame s tozi koito vzehme ot formata
        // KAZVAME DUN VALIDATORS:TRUE ZASHTOTO NE GI PUSKA I MOJEM DA ZAPISHEM TASK BES TITLE !!!
        Film.findByIdAndUpdate(id, filmChanged , {runValidators:true})
            .then( film => {
                res.redirect('/');
            });

	},

	deleteGet: (req, res) => {

		// vzimame id-to
        let id = req.params.id;

        // TOVA MOJEM I DA NE GO PISHEM NA IZPITA
        //namirame filma s tova id i go vrushtame na viewto
        Film.findById(id).then(film => {

            //proverqvame dali filma sushtestvuva
            if(!film)
            {
                res.redirect('/');
                return;
            }

            // podavame go na viewto
            res.render('film/delete' +
				'',film);
        })

    },

	deletePost: (req, res) => {

        // Vzimame ID-to
        let id = req.params.id;

        //Namirame filma po ID i go triem ot bazata, vrushtame se na '/'
        Film.findByIdAndRemove(id).then(film => {
				res.redirect('/');
            });

    }
};