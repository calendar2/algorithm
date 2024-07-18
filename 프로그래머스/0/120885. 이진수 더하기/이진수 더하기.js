function solution(bin1, bin2) {
    const bin1_arr = bin1.split('');
    const bin2_arr = bin2.split('');
    
    for (let i = 10; i >= bin1.length; i--) {
        bin1_arr.unshift('0');
    }
    
    for (let i = 10; i >= bin2.length; i--) {
        bin2_arr.unshift('0');
    }
    
    const ans_arr = new Array(11).fill('0');
    for (let i = 10; i >= 1; i--) {
        if (bin1_arr[i] === '1' && bin2_arr[i] === '1') {
            ans_arr[i-1] = '1';
        } else if (bin1_arr[i] === '0' && bin2_arr[i] === '0') {
            continue;
        } else {
            if (ans_arr[i] === '1') {
                ans_arr[i] = '0';
                ans_arr[i-1] = '1';
            } else {
                ans_arr[i] = '1';
            }
        }
    }
    
    let answer = '';
    let first = false;
    for (let i = 0; i <= 10; i++) {
        if (!first) {
            if (ans_arr[i] === '0') {
                continue;
            } else {
                first = true;
            }
        }
        
        answer += ans_arr[i];
    }
    
    if (answer === '') {
        answer = '0';
    }
    
    return answer;
}