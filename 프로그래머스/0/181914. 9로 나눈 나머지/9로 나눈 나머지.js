function solution(number) {
    var answer = 0;
    
    for (const num of number) {
        answer += Number(num);
    }
    
    return answer % 9;
}