const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    let ans = '';
    
    for (const s of str) {
        if (s === s.toLowerCase()) {
            ans += s.toUpperCase();
        } else {
            ans += s.toLowerCase();
        }
    }
    
    console.log(ans);
});