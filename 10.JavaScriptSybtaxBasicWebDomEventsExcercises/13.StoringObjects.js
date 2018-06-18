




function s(args)
{

    let arr = [];
    for(let el of args)
    {
        let input = el.split(" -> ");

        let name = input[0];
        let age = input[1];
        let grade = input[2];

        //console.log("Name: " + name);
        //console.log("Age: " + age);
        //console.log("Grade: " + grade);

        let storage = [];

        storage["Name"] = `${name}`;
        storage["Age"] = `${age}`;
        storage["Grade"] = `${grade}`;

        arr.push(storage);


    }


for( let i = 0; i < arr.length; i++)
{
    console.log("Name: " + arr[i].Name);
    console.log("Age: " + arr[i].Age);
    console.log("Grade: " + arr[i].Grade);
}



}


s([
    'Pesho -> 13 -> 6.00',
    'Ivan -> 12 -> 5.57',
    'Toni -> 13 -> 4.90'
]);



























