function solution(rank, attendance) {
    const len = rank.length;
    let size = 10000;
    let search = 1;
    var answer = 0;
    
    while (search <= len) {
        let idx = rank.indexOf(search++);
        
        if (attendance[idx]) {
            answer += size * idx;
            size /= 100;
        }
        
        if (size < 1) {
            break;
        }
    }
    
    return answer;
}