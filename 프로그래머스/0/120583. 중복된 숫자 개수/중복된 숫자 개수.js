function solution(array, n) {
    var answer = 0;
    array.map((a) => a === n && answer++);
    return answer;
}