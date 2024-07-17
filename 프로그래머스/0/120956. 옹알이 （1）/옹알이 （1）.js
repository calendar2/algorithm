function solution(babbling) {
    var answer = 0;
    
    for (const bab of babbling) {
        let left = 0;
        let right = 1;
        let isPossible = false;
        
        while (right < bab.length) {
            let sub = bab.substring(left, right+1);
            console.log(sub)
            if (sub === 'ye' || sub === 'ma' || sub === 'aya' || sub === 'woo') {
                left = right + 1;
                right += 2;
                
                if (left === bab.length-1) {
                    break;
                }
                
                if (right > bab.length-1) {
                    isPossible = true;
                }
            } else {
                if (right - left === 1) {
                    right++;
                } else {
                    break;
                }
            }
        }
        
        if (isPossible) {
                answer++;
            }
    }
    
    return answer;
}