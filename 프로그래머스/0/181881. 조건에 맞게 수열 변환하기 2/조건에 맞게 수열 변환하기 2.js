function solution(arr) {
    let loopCnt = 0;
    const len = arr.length;
    
    while (true) {
        let lenCnt = 0;
        for (let i = 0; i < len; i++) {
            if (arr[i] < 50) {
                if (arr[i] % 2) {
                    arr[i] = arr[i] * 2 + 1;
                } else {
                    lenCnt++;
                }
            } else {
                if (arr[i] % 2) {
                    lenCnt++;
                } else {
                    arr[i] /= 2;
                }
            }
        }
        
        if (lenCnt === len) {
            break;
        } else {
            loopCnt++;
        }
    }
    
    return loopCnt;
}