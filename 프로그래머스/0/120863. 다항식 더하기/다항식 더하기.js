function solution(polynomial) {
    const arr = polynomial.split(' + ');
    const x_temp = [];
    const temp = [];
    
    for (const a of arr) {
        for (let i = 0; i < a.length; i++) {
            if (a[i] === 'x') {
                if (a.length === 1) {
                    x_temp.push('1');
                } else {
                    x_temp.push(a.substring(0, a.length-1));
                }
                break;
            }
            
            if (i === a.length-1) {
                temp.push(a);
            }
        }
    }
    
    let x = x_temp.reduce((acc, cur) => acc + Number(cur), 0);
    let n = temp.reduce((acc, cur) => acc + Number(cur), 0);
    let answer = '';
    
    if (x === 0) {
        answer = '' + n;
    } else if (n === 0) {
        if (x === 1) {
            answer = 'x';
        } else {
            answer = x + 'x';
        }
    } else {
        if (x === 1) {
            answer = 'x + ' + n;
        } else {
            answer = x + 'x + ' + n;
        }
    }
    
    return answer;
}