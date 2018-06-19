

//Tuk mojem da pishem na JavaScript bez da sa ni nujni nikakvi tagove
console.log('Hello JS !');

let res = "";
for(let i = 1; i <= 10; i++)
{
    res += i + " ";
}

document.write("<h1>" + res + "</h1>");
// S document.write(i); pishem na ekana

console.log(res);
// CHISLATA OT 1 DO 10 SHTE BUDAT IZPISANI NA KONZOLATA KATO RUNNEM HTML FAILA


//VZIMAME SI BUtoNA Ot HTML DOUMENTA
let sumBtn = document.getElementById('sum');



// MOJEM DA ZAKACHME EVENTI NA TEZI VZETi DOKUMENTI, V SLUCHAQ ZAKACHAME .onclick
// I KUM NEGO SLAGAME FUNKCIQ KOQTO DA SE IZPULNI PRI KLIKVANE NA BUTONA.

// drugiqt nachin za zakachim event na buton e v samiq html
//<input onclick="ImeNaFunkciqVJSFaila" type="submit" name="btn" value="Submit!">


sumBtn.onclick = function(e){

    // TOVA E ZA DA NE SE PREZAREJDA STRANICATA SLED NATISKANETO NA BUTONA
    e.preventDefault();

    //vzimame si nomerata t.e. stoinostita zatova pishem .value
    let num1 = document.getElementById('firstNum').value;
    let num2 = document.getElementById('secondNum').value;

    // OBACHE POLUCHAVAME CHISATA KATO STRINGOVE !
    //PARSVAME SUS FUNKCIQTA  Number(); ILI S ParseInt();
    let parsedNum1 = Number(num1);
    let parsedNum2 = Number(num2);

    // SMQTAME SI REZULtata
    let result = parsedNum1 + parsedNum2;

    //ZA DA GO PRINTIRAME V POLETO TRQBVA PURVO DA GO VZEMEM
    // NE E NUJNO DA PARSVAME NISHTO
    let resultField = document
        .getElementById('resultField');


    // I NARAQ SETVAME STOINOSTTA DA E RAVNA NA REZULTATA !
    resultField.value = result;

    //SHtE NAPRAVIM LABEL NA Result: V HTMLa I OT TUK SHTE GO VZEMEM; SHte gO NAPRAVIM CHERVEN:

    let label = document.getElementById('result_lbl');

    // IZPOLZVAME setAttribute za da rabotim sus CSS vurhu HTMLa
    label.setAttribute('style', 'color:red');

    //SHTE NAPRAVIM I FIELDA DA E DESABLED SLED NATISKANETO NA BUTONA:
    resultField.setAttribute("disabled", "disabled")


    //OBACHE STRANICATA SE PREZAREJDA SLED KATO NATISNEM BUTONA
    //BUTONITE AKO SA VUV FORM TAG SLED NATISKANETO IZPRASHTAT TOZI
    //FORMULQT I PREZAREJDAT STRANICATA TOVA E POVEDENIE PO DEFAULT

    //RESHENIE : ILI MAHAME FORM TAGA ILI SLAGAME EVENT PARAMETUR VUV
    //FUNKCIQTA I I MAHAME DEFAULT POVEDENIETO SUS e.preventDefault();
};


// DOKATO PRAVIM KAKVOTO I DA BILO VINAGI MOJEM DA TESTVAME V KONZOLATA









