function solution(chicken) {
    // 0은 치킨 갯수, 1은 쿠폰 갯수, 2는 서비스 받은 갯수
    var answer = new Array(3);
    answer[0] = chicken;
    answer[1] = chicken;
    answer[2] = 0;
    
    while (answer[1] >= 10) {
        const temp = Math.floor(answer[1] / 10);
        const div = answer[1] % 10;
        
        answer[2] += temp;
        answer[1] = temp + div;
    }
    
    return answer[2];
}