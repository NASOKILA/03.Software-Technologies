

arr = ["750"];
function solve(num = arr)
{
    let n = Number(num);

    function isSym(number = n) {
            number = number.toString();
            let length = number.length;
            for (let i = 0; i < length / 2; i++) {
                if (number[i] !== number[length - i - 1]) {
                    return false;
                }
            }
            return true;
        }

    for(let i = 1; i <= n; i++) {

        if(isSym(i) === true)
        {
            console.log(i);
        }
    }

}


solve();





























