function solution(s) {
    const obj = {};
    
    for (const letter of s) {
        if (obj[letter] === undefined) {
            obj[letter] = 1;
        } else {
            obj[letter]++;
        }
    }
    
    var answer = '';
    const keys = Object.keys(obj).sort();
    for (const key of keys) {
        if (obj[key] === 1) {
            answer += key;
        }
    }

    return answer;
}