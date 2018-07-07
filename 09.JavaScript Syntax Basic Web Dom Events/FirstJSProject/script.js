
console.log('Hello JS !');

let res = "";
for(let i = 1; i <= 10; i++)
{
    res += i + " ";
}

document.write("<h1>" + res + "</h1>");

console.log(res);

let sumBtn = document.getElementById('sum');

sumBtn.onclick = function(e){

    e.preventDefault();

    let num1 = document.getElementById('firstNum').value;

    let num2 = document.getElementById('secondNum').value;

    let parsedNum1 = Number(num1);

    let parsedNum2 = Number(num2);

    let result = parsedNum1 + parsedNum2;

    let resultField = document
        .getElementById('resultField');

    resultField.value = result;

    let label = document.getElementById('result_lbl');

    label.setAttribute('style', 'color:red');

    resultField.setAttribute("disabled", "disabled")
};

