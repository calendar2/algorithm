function solution(array) {
    array.sort((a, b) => a - b);
    var answer = array[Math.floor(array.length / 2)];
    return answer;
}