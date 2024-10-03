function solution(n, lost, reserve) {
    var answer = 0;
    const attend = new Array(n+1).fill(true);
    const new_reserve = [];
    
    // 체육복 잃어버린 애들을 false로
    for (const l of lost) {
        attend[l] = false;
    }
    
    reserve.sort((a, b) => a - b);
    // 여벌을 가진 학생이 잃어버렸는지
    for (const r of reserve) {
        if (!attend[r]) {
            attend[r] = true;
        } else {
            new_reserve.push(r);
        }
    }
    
    // 체육복 여벌로 커버가 되는지
    for (const r of new_reserve) {
        // 2. 그게 아니라면 이 여벌로 자기 앞,뒤로 커버가 가능한지?
        if (r < n) {
            if (!attend[r-1]) {
                attend[r-1] = true;
                continue;
            } else if (!attend[r+1]) {
                attend[r+1] = true;
                continue;
            }
        } else {
            if (!attend[r-1]) {
                attend[r-1] = true;
                continue;
            }
        }
    }
    
    // 그리고 총 출석이 가능한 학생 수 세기
    for (let i = 1; i <= n; i++) {
        if (attend[i]) {
            answer++;
        }
    }
    
    return answer;
}