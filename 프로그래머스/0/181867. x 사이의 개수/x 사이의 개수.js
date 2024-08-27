function solution(myString) {
    var answer = [];
    const temp = myString.split('x');
    
    for (const s of temp) {
        answer.push(s.length);
    }
    
    return answer;
}