function solution(spell, dic) {
    var answer = 2;
    const visited = [];
    for (let i = 0; i < spell.length; i++) {
        visited.push(0);
    }
    
    for (const di of dic) {
        for (let i = 0; i < spell.length; i++) {
            visited[i] = 0;
        }
        
        for (let i = 0; i < di.length; i ++) {
            for (let j = 0; j < spell.length; j++) {
                if (di[i] === spell[j]) {
                    visited[j]++;
                }
            }
        }
        
        for (let i = 0; i < visited.length; i++) {
            if (visited[i] !== 1) {
                break;
            }
            
            if (i === visited.length-1) {
                answer = 1;
            }
        }
        
        if (answer === 1) {
            break;
        }
    }
    
    return answer;
}