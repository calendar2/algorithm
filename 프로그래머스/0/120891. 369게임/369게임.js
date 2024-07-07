function solution(order) {
    const str_order = '' + order;
    let answer = 0;
    
    for (const letter of str_order) {
        if (letter !== '0' && Number(letter) % 3 === 0) {
            answer++;
        }
    }
    return answer;
}