const mongoose = require('mongoose');
//Vzimame si mongoose

//Pravim si shema
let filmSchema = mongoose.Schema({

    //Propertitata se definirat kato obekti
    name: {type: String, required: true},
    genre: {type: String, required: true},
    director: {type: String, required: true},
    year: {type: Number, required: true}

});

//Pravim shemata na model
let Film = mongoose.model('Film', filmSchema);

//Pravim q dostupna za drugi failove
module.exports = Film;