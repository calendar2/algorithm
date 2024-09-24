function solution(s) {
    var answer = new Array(2).fill(0);
    let q = s;
    
    while (q !== '1') {
        // 1. 모든 0을 제거
        const arr = q.split('');
        let new_q = '';
        
        for (let i = 0; i < arr.length; i++) {
            if (arr[i] === '1') {
                new_q += '1';
            } else {
                answer[1]++;
            }
        }
        
        // 2. x의 길이에 해당하는 이진수로 변환
        let len = new_q.length;
        let bin = '';
        
        while (len !== 0) {
            bin = len % 2 + bin;
            len /= 2;
            len = Math.floor(len);
        }
        
        q = bin;
        answer[0]++;
    }
    
    return answer;
}