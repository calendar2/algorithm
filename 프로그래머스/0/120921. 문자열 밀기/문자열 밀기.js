function solution(A, B) {
    var answer = 0;
    const A_arr = A.split('');
    const B_arr = B.split('');
    
    if (A === B) {
        return answer;
    }
    
    let isPossible = false;
    for (let i = 1; i <= A.length; i++) {
        A_arr.unshift(A_arr.pop());
        for (let j = 0; j < A.length; j++) {
            if (A_arr[j] !== B_arr[j]) {
                break;
            }
            
            if (j === A.length-1) {
                answer = i;
                isPossible = true;
            }
        }
        
        if (isPossible) {
            break;
        }
    }
    
    if (!isPossible) {
        answer = -1;
    }
    
    return answer;
}