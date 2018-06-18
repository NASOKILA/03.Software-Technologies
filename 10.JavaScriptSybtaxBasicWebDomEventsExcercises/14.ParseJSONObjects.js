


function solve(args)
{
    let students = args.map(a => JSON.parse(a));

    for(let el of students)
    {
        let jsonObj = JSON.parse(el);
        console.log("Name: " + jsonObj.name);
        console.log("Age: " + jsonObj.age);
        console.log("Date: " + jsonObj.date);
    }
}


solve([
    '{"name":"Gosho","age":10,"date":"19/06/2005"}',
    '{"name":"Tosho","age":11,"date":"04/04/2005"}',
    '{"name":"Maria","age":24,"date":"31/12/1996"}'
]);








