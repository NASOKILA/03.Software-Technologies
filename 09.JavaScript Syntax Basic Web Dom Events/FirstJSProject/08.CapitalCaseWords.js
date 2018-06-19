

function solve(args){

    let words = args
        .join(' ')  // joinvame gi s prazen string ZAHTOTO POLUCHAVAME MNOGOGO ELEMENTI
        .split(/\W+/)  // splitvame s regex
        .filter(w => w.length > 0) //mahame tazi koito sa s length 0
        .filter(x => x === x.toUpperCase()) // vzimame SAMO TEZI NAPISANI S UPPERCASE
        .join(', ');  // izpisvame gi joinati su zpetaq

        //Moje da se napravi i s for cikul obache e mnogo pisane.

        // MOJEM DA NAPISHEM I new RegExp('\W+');

console.log(words);
}

solve();
// poluchavame msiv s mnogo elementi za tova gi joinvame v nachaloto
// za da stane na edin tekst, posle splitvame po regeksa, vzimame
// samo tezi koito sa s poveche ot 0 elementi, i posle vzimame samo
// tezi koito sa s glavni bukvi !!!




















