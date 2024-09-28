function solution(participant, completion) {
    const hash = new Map();
    
    for (const p of participant) {
        let cnt = hash.get(p);
        if (cnt === undefined) {
            hash.set(p, 1);
        } else {
            hash.set(p, cnt+1);
        }
    }
    
    for (const c of completion) {
        let cnt = hash.get(c);
        if (cnt === 1) {
            hash.delete(c);
        } else {
            hash.set(c, cnt-1);
        }
    }
    
    let answer = '';
    for (const [key, value] of hash) {
        answer = key;
    }
    
    return answer;
}