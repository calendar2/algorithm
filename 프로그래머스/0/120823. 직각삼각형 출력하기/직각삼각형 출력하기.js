const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    const n = Number(input[0]);
    const width = [];
    let star = "";
    
    for (let i = 0; i < 10; i++) {
        star += "*";
        width.push(star);
    }
    
    for (let i = 0; i < n; i++) {
        console.log(width[i]);
    }
});