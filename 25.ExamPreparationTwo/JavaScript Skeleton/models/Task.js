const mongoose = require('mongoose');

let taskSchema = mongoose.Schema({
    title: {type: 'string', required:'true'},
    status: {type:'string', required:'true'}
});

// DOBAVQME IME NA KOLEKCIATA T.E. TABLICATA
let Task = mongoose.model('Task', taskSchema, 'allTasks');

module.exports = Task;

//SEGA TRQBVA DA OTDEM V ROBOMONGO I DA SI NAPRAVIM BAZATA SUS KOLEKCIQTA
//ZA BAZATA VZEMI IMETO OT config.js FAILA, VIJ POSLEDNOTO NA connectionString:
//A KOLEKCIQTA VECHE Q KRUSTIHME allTasks
