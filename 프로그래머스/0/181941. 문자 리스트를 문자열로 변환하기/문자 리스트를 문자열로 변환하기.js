function solution(arr) {
    var answer = arr.reduce((acc, cur) => acc + cur, '');
    return answer;
}