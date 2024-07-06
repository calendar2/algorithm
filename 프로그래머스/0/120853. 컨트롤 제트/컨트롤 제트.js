function solution(s) {
    const sArr = s.split(' ');
    const stack = [];
    
    for (const i of sArr) {
        if (i === 'Z') {
            stack.pop();
        } else {
            stack.push(Number(i));
        }
    }
    
    return stack.reduce((acc, cur) => acc + cur, 0);
}