const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().split("\n");

let idx = -1;
let num = 0;

for (let i = 0; i < 3; i++) {
  if (!isNaN(input[i])) {
    num = Number(input[i]);
    idx = i;
    break;
  }
}

switch (idx) {
  case 0:
    num += 3;
    break;
  case 1:
    num += 2;
    break;
  case 2:
    num += 1;
    break;
}

if (num % 3 === 0 && num % 5 === 0) {
  console.log("FizzBuzz");
} else if (num % 3 === 0) {
  console.log("Fizz");
} else if (num % 5 === 0) {
  console.log("Buzz");
} else {
  console.log(num);
}
