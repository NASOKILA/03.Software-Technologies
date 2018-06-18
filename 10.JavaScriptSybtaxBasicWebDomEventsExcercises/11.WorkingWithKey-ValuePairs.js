


function solve(args)
{
    // let dictionary = new Map();
    let dictionary = [];
    let keyToPrint = args[args.length-1];

    for( i = 0; i < args.length -1; i++)
    {

            let input = args[i].split(" ");
            let key = input[0];
            let value = input[1];


            dictionary[key] = value;
            //dictionary.set(`${key}`, `${value}`);
    }

    if(keyToPrint in dictionary)
        console.log(dictionary[keyToPrint]);
    else
        console.log("None");
}


solve([ '3 bla', '3 alb', '2']);

