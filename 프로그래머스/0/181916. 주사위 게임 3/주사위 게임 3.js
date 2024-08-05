function solution(a, b, c, d) {
    const counts = new Array(7).fill(0);
    counts[a]++;
    counts[b]++;
    counts[c]++;
    counts[d]++;
    
    let answer = 1;
    for (let i = 1; i <= 6; i++) {
        if (counts[i] === 4) {
            answer = 1111 * i;
        } else if (counts[i] === 3) {
            for (let j = 1; j <= 6; j++) {
                if (counts[j] === 1) {
                    answer = (10 * i + j) * (10 * i + j);
                }
            }
        } else if (counts[i] === 2) {
            for (let j = 1; j <= 6; j++) {
                if (i !== j) {
                    if (counts[j] === 2) {
                        answer = (i + j) * Math.abs(i - j);
                    } else if (counts[j] === 1) {
                        answer *= j;
                    }
                }
            }
        }
    }
    
    if (answer === 1) {
        for (let i = 1; i <= 6; i++) {
            if (counts[i] === 1) {
                answer = i;
                break;
            }
        }
    }
    
    return answer;
}