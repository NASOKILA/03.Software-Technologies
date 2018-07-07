


function s(args)
{
    let arr = {};

    let keyToPrint = args[args.length-1];

    for(let i = 0; i < args.length -1; i++)
    {
        let input = args[i].split(" ");
        let key = input[0];
        let value = input[1];

        let values = [];

        if(!(key in arr))
        {
            values.push(value); 
            arr[key] = values; 
        }
        else
        {
            values = arr[key];
            values.push(value);
            arr[key] = values;
        }

    }

    if(arr[keyToPrint]) {
        for (let el of arr[keyToPrint]) {
            console.log(el);
        }
    }
    else
    {
        console.log("None");
    }
}

s(['3 bla',
    '3 alb',
    '3'
]);
