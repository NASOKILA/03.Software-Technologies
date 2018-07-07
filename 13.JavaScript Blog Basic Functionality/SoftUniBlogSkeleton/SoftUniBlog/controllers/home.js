const mongoose = require('mongoose');
const Article = mongoose.models.Article;

module.exports = {
  index: (req, res) => {

      Article.find({}).limit(6).populate('author').then(articles => {

       articles.forEach( article => {
           article.content = article.content.substring(0, 20) + ' . . . '});
          res.render('home/index', {articles: articles});


      });
   }
};
