
// inportva si home kontrollera
const homeController = require('./../controllers/home');


// exportvame applikaciqta
// ako poluchim get zaqvka na '/' da izpulni indexGet actiona ot home Kontrollera
module.exports = (app) => {

    // ako poluchim get zaqvka na '/' da izpulni indexGet actiona ot home Kontrollera
    app.get('/', homeController.indexGet);

    // ako poluchim post zaqvka na '/' da izpulni indexPost actiona ot home Kontrollera
    // TRQBVA DA SI NAPRAVIM TAKUV ACTION V HOMEKONTROLLERA
    app.post('/', homeController.indexPost);



};







