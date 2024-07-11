function solution(n) {
    var answer = Math.sqrt(n) === Math.floor(Math.sqrt(n)) ? 1 : 2;
    return answer;
}