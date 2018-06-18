



function solve(args)
{
    let kvp = {};
    function TryParseInt(str,defaultValue) {
        var retValue = defaultValue;
        if(str !== null) {
            if(str.length > 0) {
                if (!isNaN(str)) {
                    retValue = parseInt(str);
                }
            }
        }
        return retValue;
    }
    for(let el of args)
    {
        let input = el.split(" -> ");





        let key = input[0];
        let value = TryParseInt(`${input[1]}`, 0);

        if(value === 0)
            value = input[1];

        kvp[key] = value;




    }
    let json = JSON.stringify(kvp);
    console.log(json);


}

solve([
    'name -> Angel',
    'surname -> Georgiev',
    'age -> 20',
    'grade -> 6.00',
    'date -> 23/05/1995',
    'town -> Sofia'
    ]);

















