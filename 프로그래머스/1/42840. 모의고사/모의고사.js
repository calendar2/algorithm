function solution(answers) {
    const first = [1, 2, 3, 4, 5];
    const second = [2, 1, 2, 3, 2, 4, 2, 5];
    const third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    const cnt1 = check(first, answers);
    const cnt2 = check(second, answers);
    const cnt3 = check(third, answers);
    
    if (cnt1 === cnt2) {
        if (cnt1 === cnt3) {
            return [1, 2, 3];
        } else if (cnt1 > cnt3) {
            return [1, 2];
        }
    } else if (cnt1 > cnt2) {
        if (cnt1 === cnt3) {
            return [1, 3];
        } else if (cnt1 > cnt3) {
            return [1];
        }
    } else {
        if (cnt2 === cnt3) {
            return [2, 3];
        } else if (cnt2 > cnt3) {
            return [2];
        }
    }
    
    return [3];
}

const check = (arr, answers) => {
    let cnt = 0;
    for (let i = 0; i < answers.length; i++) {
        if (answers[i] === arr[i % arr.length]) {
            cnt++;
        }
    }
    
    return cnt;
}