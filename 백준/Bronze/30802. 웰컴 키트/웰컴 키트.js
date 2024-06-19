const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().split("\n");

const N = Number(input[0]);
const shirtSize = input[1].split(" ").map(Number);
const T = input[2].split(" ").map(Number)[0];
const P = input[2].split(" ").map(Number)[1];

// 티셔츠 갯수
let t_cnt = 0;
for (const size of shirtSize) {
  if (size !== 0) {
    if (size % T == 0) {
      t_cnt += size / T;
    } else {
      t_cnt += Math.floor(size / T) + 1;
    }
  }
}

// 펜 갯수
let p_group = Math.floor(N / P);
let p_cnt = N % P;

console.log(t_cnt);
console.log(p_group, p_cnt);
