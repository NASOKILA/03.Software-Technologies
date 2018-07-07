
const Article = require('mongoose').model('Article');


module.exports = {
    createGet: (req, res) => {

        let error = "";
        if(!req.isAuthenticated())
            error = "Please log in to your account!";

        if(error)
        {
            res.render('user/register', {error: error});
            return;
        }

            res.render('article/create');
    },

    createPost: (req, res) => {
        let articleArgs = req.body;

        let errorMsg = '';

        if(!req.isAuthenticated())
        {
            errorMsg = 'You should be logged in to make articles!'
        }else if(!articleArgs.title)
        {
            errorMsg = 'Invalid title!'
        }else if(!articleArgs.content)
        {
            errorMsg = 'Invalid content!';
        }

        if(errorMsg) {
            res.render('article/create', {error:errorMsg});
            return;
        }

        articleArgs.author = req.user.id;

        Article.create(articleArgs).then(article => {
           req.user.article.push(article.id);
           req.user.save(err => {

                if(err)
                {
                    res.redirect('/', {error: err.message})
                }else
                {
                    res.redirect('/')
                }

            });
        })
    },

    details: (req, res) => {

        let articleId = req.params.id;

        Article.findById(articleId).populate('author').then(article => {
            res.render('article/details', {article: article});
        });
    },


};
