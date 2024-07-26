function solution(a, b) {
    const ab = '' + a + b;
    const ba = '' + b + a;
    var answer = Math.max(ab, ba);
    return answer;
}