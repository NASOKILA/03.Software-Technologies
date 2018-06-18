



function solve(args)
{
    let lengthOfArray = Number(args[0]);

    let result = [];
    for(let i = 0; i < lengthOfArray; i++)
    {
        // set every element of the array to 0
        result[i] = 0;
    }

    for(let i = 1; i < args.length; i++)
    {
        let element = args[i]. split(" ");

        let index = Number(element[0]);
        let value = Number(element[2]);

        result[index] = value;


    }

for(let el of result)
    console.log(el);

}


solve([ '5', '0 - 3', '3 - -1', '4 - 2' ]);











