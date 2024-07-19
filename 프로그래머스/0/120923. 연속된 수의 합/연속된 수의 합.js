function solution(num, total) {
    var answer = new Array(num).fill(0);
    const mid_idx = Math.floor(num / 2);
    const mid = Math.ceil(total / num);
    answer[mid_idx] = mid;
    
    // 아래 인덱스 채우기
    let idx = mid_idx - 1;
    let value = mid - 1;
    while (idx >= 0) {
        answer[idx] = value;
        idx--;
        value--;
    }
    
    // 오른쪽 인덱스 채우기
    idx = mid_idx + 1;
    value = mid + 1;
    while (idx < num) {
        answer[idx] = value;
        idx++;
        value++;
    }
    
    return answer;
}