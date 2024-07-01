function solution(age) {
    const table = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'];
    let answer = '';
    const age_str = "" + age;
    
    for (const idx of age_str) {
        answer += table[Number(idx)];
    }
    
    return answer;
}