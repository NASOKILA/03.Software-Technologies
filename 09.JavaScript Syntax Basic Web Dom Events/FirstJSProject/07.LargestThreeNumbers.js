
let nums = [30,20];

function solve(args = nums)
{
    let arrLength = args.length;
    let counter = 1;
    while(true) {
        args = args.map(Number).sort((a, b) => b - a); // PRAVIM GI NA NOMERA
        console.log(args[counter-1]);
        if(counter === Math.min(3, arrLength))
            break;
        counter++;
    }
}
solve();





















