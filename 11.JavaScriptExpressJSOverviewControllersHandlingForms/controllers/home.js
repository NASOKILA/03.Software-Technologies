let Calculator = require('../models/Calculator');



module.exports = {
    indexGet: (req, res) => {
        res.render('home/index');
    },

    // SUZDAVAME SI INDEX POST ACTION
    indexPost: (req, res) => {
        // purvo trqbva da si vzemem requesta koito e izpraten ot usera

        //tova stava sus req.body
        // NO ZA DA VZEMEM TOVA KOETO NI E NUJNO PODAVAME 'calculator' KATO PARAMETUR:
        let calculatorParams = req.body['calculator'];


        // PREDI DA POLZVAME NASHQ MODEL TRQBVA DA KAJEM NA KONTROLLERA CHE SUSHTESTVUVA
        // PISHEM let Calculator = require('../models/Calculator');
        // davame papka nazat, vlizame v models i pishem imeto na faila


        // sega trqbva da si napravim nov kalkulator za da mojem da zapazim neshtata v nego
        let calculator = new Calculator();


        //Parsvame tova koeto sme poluchili ot usera zashtoto gi poluchavame kato stringove
        //i gi setvame v noviqt ni kalkulator
        calculator.leftOperand = Number(calculatorParams.leftOperand);
        calculator.rightOperand = Number(calculatorParams.rightOperand);
        calculator.operator = calculatorParams.operator;


        /*
        *
        * PO PRINCIP MOJEM PROSTO DA PODADEM SLEDNITE PARAMETRI KUM NOVIQT KALKULATOR:
        * let leftOperand = Number(calculatorParams.leftOperand);
        * let rightOperand = Number(calculatorParams.rightOperand);
        * let calculator.operator = calculatorParams.operator;
        *
        * let calculator = new Calculator(leftOperator, rightOperator, operator);
        *
        * */

        // Sega e vreme da izpolzvame funkciqta calculateResult() koqto si napravihme v modela
        // Tova obache go pravim sled kato setnem stoinostite kum calculator
        let result = calculator.CalculateResult();


        // renderirame  viewto index v papkata home samoche mu podavame KATO OBEKT
        // calculatora i rezultata ot funkciqta CalculateResult();
        // PARAMETURUT VINAGI E JAVASKRIPTSKI OBEKT, key -> value PAIRS
        res.render('home/index', {'calculator': calculator, 'result':result});


    }


};