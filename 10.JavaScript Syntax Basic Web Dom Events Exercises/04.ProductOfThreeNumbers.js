

function solve(args)
{
    let x = Number(args[0]);
    let y = Number(args[1]);
    let z = Number(args[2]);

    let negativeNumsCount = 0;

    if(x < 0)
        negativeNumsCount++;
    if(y < 0)
        negativeNumsCount++;
    if(z < 0)
        negativeNumsCount++;

    if(negativeNumsCount % 2 === 0)
        console.log("Positive");
    else
        console.log("Negative");

}

solve([ '2', '3', '1' ]);







