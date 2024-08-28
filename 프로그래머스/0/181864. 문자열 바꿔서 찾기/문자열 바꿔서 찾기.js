function solution(myString, pat) {
    var answer = myString.split('').map(v => v === 'A' ? 'B' : 'A').join('');
    return answer.includes(pat) ? 1 : 0;
}