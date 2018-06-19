
function solve(args)
{
    let N = Number(args[0]);
    let X = Number(args[1]);
    if(X >= N)
        console.log(N * X);
    else if(N > X)
        console.log(N / X);
}
solve([ '2', '3' ]);


