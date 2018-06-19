


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
            // ako masiva ne sudurja tozi kluch
            values.push(value); // dobavqme si stoinostta v masiva za stoinosti
            arr[key] = values; // dobavqme si vsichko kum glavniq masiv
        }
        else
        {
            // ako klucha veche e sudurja v masiva

            //1. take the values of that key
            //2. add the current value to them
            //3. add everithing to the main array

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


    // MOJE DA SE NAPRAVI I SUS TERNALEN OPERATOR

}

s(['3 bla',
    '3 alb',
    '3'
]);
















