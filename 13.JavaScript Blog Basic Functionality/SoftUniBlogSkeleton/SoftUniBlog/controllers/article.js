
// Mojem da izvikame models chrez mongoose samo kato mu napishem imeto !
const Article = require('mongoose').model('Article');

// We want to create a method which will render the form for creating an article.
// The controller might look like this.

module.exports = {
    createGet: (req, res) => {
        //renderirame view koeto trqbva da si napravim

        //SHTE NAPRAVIM I TUK AUTENTICACIQ; TOVA E KATO ZA DOMASHNO:
        //Pravim go v GET metoda za da ne mojem direktno ot linka article/create
        //da dostupim stranicata ako ne sme lognati

        let error = "";
        if(!req.isAuthenticated())
            error = "Please log in to your account!";

        if(error)
        {
            // ako ima greshka da renderira user/register stranicata i da
            //pokaje greshkata !!!
            res.render('user/register', {error: error});
            return;
        }

            res.render('article/create');



    },

    createPost: (req, res) => {
        // we take the article properties
        let articleArgs = req.body;

        // Sega zapochvame da pravim proverki:

        let errorMsg = '';

        //req.isAuthenticated() comes from the passport module and
        // it checks if there is currently a logged in user.
        if(!req.isAuthenticated())
        {
            errorMsg = 'You should be logged in to make articles!'
        }else if(!articleArgs.title)
        {
            // ako articleArgs.title e false t.e. ili e empty, undefined ili null
            errorMsg = 'Invalid title!'
        }else if(!articleArgs.content)
        {
            // ako articleArgs.content e false t.e. ili e empty, undefined ili null
            errorMsg = 'Invalid content!';
        }

        if(errorMsg) {
            // Ako ima greshka q podavame na viewto i to shte q pokaje
            res.render('article/create', {error:errorMsg});
            return;
        }

        //1.Assign the author’s id to the article object
        articleArgs.author = req.user.id;

        //2.Save the article to the database & o	Attach an “id”
        // to the article, which we will add to the author’s articles later
        Article.create(articleArgs).then(article => {
           req.user.article.push(article.id);
           req.user.save(err => {

                if(err)
                {
                    res.redirect('/', {error: err.message})
                }else
                {
                    // Ako nqma prosto redirektvame kum glavnata stranica
                    res.redirect('/')
                }

            });
        })
    },

    details: (req, res) => {

        let articleId = req.params.id;

        //Namirame artikula po Id-to
        Article.findById(articleId).populate('author').then(article => {
            res.render('article/details', {article: article});
        });
    },


};




//// {{#if VARIABLE}} ... {{/if}}     i  {{#unless VARIABLE}} ... {{/unless}}
//// TEZI SA KATO IF I ELSE ZA NASHIQ VIEWENGINE V HTML-a
//// Ako promenlivata e vqrna shte se izpulni if-a ako ne e shte se izpulni els-a


//// But how does the view know about the current user? Look at “express.js” – there
//// is a middleware that binds user in way that allows to be visible to the view









