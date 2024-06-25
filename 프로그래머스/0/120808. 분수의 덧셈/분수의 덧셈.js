function solution(numer1, denom1, numer2, denom2) {   
    // 분자, 분모 구하기
    let numer = numer1 * denom2 + numer2 * denom1;
    let denom = denom1 * denom2;
    
    // 분자와 분모 중에 작은 값
    let min = Math.min(numer, denom);
    
    // 2부터 min까지 차례로 나누며 기약 분수 확인
    let num = 2;
    while (num <= min) {
        if (numer % num === 0 && denom % num === 0) {
            numer /= num;
            denom /= num;
        } else {
            num++;
        }
    }
    
    const answer = [numer, denom];
    return answer;
}