function solution(numbers) {
    var answer = '';
    let idx = 0;
    
    while (idx < numbers.length) {
        switch (numbers[idx]) {
            case 'z' :
                answer += '0';
                idx += 4;
                break;
            case 'o' :
                answer += '1';
                idx += 3;
                break;
            case 't' :
                if (numbers[++idx] === 'w') {
                    answer += '2';
                    idx += 2;
                } else {
                    answer += '3';
                    idx += 4;
                }
                break;
            case 'f' :
                if (numbers[++idx] === 'o') {
                    answer += '4';
                } else {
                    answer += '5';
                }
                idx += 3;
                break;
            case 's' :
                if (numbers[++idx] === 'i') {
                    answer += '6';
                    idx += 2;
                } else {
                    answer += '7';
                    idx += 4;
                }
                break;
            case 'e' :
                answer += '8';
                idx += 5;
                break;
            case 'n' :
                answer += '9';
                idx += 4;
                break;
        }
    }
    
    return Number(answer);
}