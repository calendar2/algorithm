function solution(diffs, times, limit) {
    // level의 최대값 찾기
    const len = diffs.length;
    let right = 0;
    for (let i = 0; i < len; i++) {
        if (right < diffs[i]) {
            right = diffs[i];
        }
    }
    
    // 이분 탐색
    let left = 1;
    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        
        // mid level로 게임 시작
        let round = 0;
        let time = 0;
        let isClear = true;
        while (round < len) {
            if (mid >= diffs[round]) {
                time += times[round];
                round += 1;
            } else {
                const cnt = diffs[round] - mid;
                time += (times[round] + times[round-1]) * cnt;
                time += times[round];
                round += 1;
            }
            
            if (time  > limit) {
                isClear = false;
                break;
            }
        }
        
        if (isClear) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return left;
}