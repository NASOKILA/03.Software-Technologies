
function solve(args){

    let words = args
        .join(' ')  
        .split(/\W+/)
        .filter(w => w.length > 0)
        .filter(x => x === x.toUpperCase())
        .join(', ');  

    console.log(words);
}

solve();




















