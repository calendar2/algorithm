function solution(intStrs, k, s, l) {
    var answer = [];
    
    for (const intStr of intStrs) {
        const subStr = intStr.substring(s, s+l);
        if (k < Number(subStr)) {
            answer.push(Number(subStr));
        }
    }
    
    return answer;
}