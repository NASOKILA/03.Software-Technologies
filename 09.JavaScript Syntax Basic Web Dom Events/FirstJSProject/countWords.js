


let text = "Software University University nasko hahaha";
let arr = text.split(" ");
let arr2 = arr;
console.log(arr);

let wordCount = [];
for(let word of arr)
{

    if(!wordCount.includes(word))
    {
        wordCount.push(word);
    }
}
console.log(wordCount.length);
















