


let jsonData = [
    {"town":"Sofia","income":200},
    {"town":"Varna","income":120},
    {"town":"Pleven","income":60},
    {"town":"Varna","income":70}

];
function solve(args) {

    let towns = [];
    let arrResult = [];
    for (let datas of args) {

        let data = JSON.parse(datas);

        let town = data.town;
        let income = data.income;

        if (!towns.includes(town)) // ako ne sudurja grada
        {
            towns.push(town);
            arrResult.push({"town":town, "income": income});
        }
        else
        {

        let obj = arrResult
            .filter(x => x.town === town);

            let oldIncome = obj[0].income;
            oldIncome += income;

            let index = arrResult.indexOf(obj[0]);
            arrResult.splice(index,1);

            arrResult.push({"town":town, "income": oldIncome});

        }

    }

    //A FUNCTION TO SORT ANYTHING;
    var sort_by = function(field, reverse, primer) {

        var key = primer ?
            function (x) {
                return primer(x[field])
            } :
            function (x) {
                return x[field]
            };

        reverse = !reverse ? 1 : -1;

        return function (a, b) {
            return a = key(a), b = key(b), reverse * ((a > b) - (b > a));
        }
    }

    for( townAndIncome of arrResult.sort(sort_by('town', false, function(a){return a;})))
    {
        let town = townAndIncome.town;
        let income = townAndIncome.income;

        console.log(town + " -> " + income);
    }


}
solve([
    '{"town":"Sofia","income":200}',
    '{"town":"Varna","income":120}',
    '{"town":"Pleven","income":60}',
    '{"town":"Varna","income":70}'

]);














