function solution(cipher, code) {
    var answer = '';
    
    for (let i = 0; i < cipher.length; i++) {
        if (i % code === code - 1) {
            answer += cipher[i];
        }
    }
    return answer;
}