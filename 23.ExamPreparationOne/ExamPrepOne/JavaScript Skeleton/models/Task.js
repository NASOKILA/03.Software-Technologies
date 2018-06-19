//1. requirvame si mongooose
const mongoose = require('mongoose');

//TODO: Implement me...

//2. pravim si shemata na modela:
let taskSchema = mongoose.Schema({

    // slagame si propertitata
    // ID-to E PO DEFAULT SLOJENO
    title:{type: 'string', required:'true'},
    comments:{type: 'string', required: 'true'},
});

//3. trqbva da previrnem shemata v model: DAVAME MU NQKAKVO IME I NU PODAVAME NASHATA SHEMA
let Task = mongoose.model('Task', taskSchema);

//4. exportvame modela ZA DA MOJEM DA GO POLZVAME IZVUN TOZI FAIL
module.exports = Task;

// MODELA E GOTOV


