function solution(s) {
    const arr = s.split(' ');
    const len = arr.length
    
    for (let i = 0; i < len; i++) {
        arr[i] = Number(arr[i]);
    }
    arr.sort((a, b) => a-b);
    
    return `${arr[0]} ${arr[len-1]}`;
}