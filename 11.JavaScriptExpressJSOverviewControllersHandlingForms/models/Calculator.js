

// slednata funkciq shte se izvika kogato kogato napishem new Calculator()
// t.e. kogato si napravim nova instanciq na nashiqt kalkulator
function Calculator(leftOperand, operator, rightOperand)
{
    // definirame si operandite i gi setvame
    this.leftOperand = leftOperand;
    this.operator = operator;
    this.rightOperand = rightOperand;


    // pravim si funkciq koqto da ni reshava rezultata koito
    // zavisi ot operatora:
    this.CalculateResult = function(){

        let result = 0;
        switch (this.operator)
        {
            case "+":
                result = this.leftOperand + this.rightOperand;
                break;
            case "-":
                result = this.leftOperand - this.rightOperand;
                break;
            case "*":
                result = this.leftOperand * this.rightOperand;
                break;
            case "/":
                result = this.leftOperand / this.rightOperand;
                break;
        }

        return result;

    };



}

// Trqbva da si exportnem modela za da moje da se polzva ot drugi failove.
module.exports = Calculator;



























