
// we require mongoose
const mongoose = require('mongoose');

// define article scheme
let articleSchema = mongoose.Schema({
    title: {type: String, required: true},
    content: {type: String, required: true},
    author: {type: mongoose.Schema.Types.ObjectId, required: true, ref: 'User'},
    date: {type: Date, default : Date.now()}
});


const Article = mongoose.model('Article', articleSchema);

// we can use this scheme to performe CRUD operations
// this means we can apply this scheme to other articles.

//we hate to export it:
module.exports = Article;

/*
  we export it and we add a reference to the dadabase.js file so the dadabase knows
  that this models exists and it can use it !!!
  require('./../models/Article');
 */








