

function solve(args)
{
    let arr = [];
    for(let el of args)
    {
        let elements = el.split(" ");
        let command = elements[0];
        let num = Number(elements[1]);

            if (el.startsWith("add")) {
                arr.push(num)
            }
            else {
                if(num >= 0 && num < arr.length) {
                    arr.splice(num, 1);
                }

            }

    }

    for(let elem of arr)
    {
        console.log(elem);
    }

}


solve(['add 3', 'add 5', 'remove 2', 'remove 0', 'add 7', 'remove -1']);







