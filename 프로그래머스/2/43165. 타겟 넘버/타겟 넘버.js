let cnt = 0;

function solution(numbers, target) {
    dfs(numbers, 0, 0, target);
    
    return cnt;
}

const dfs = (numbers, idx, result, target) => {
    if (idx === numbers.length) {
        if (result === target) {
            cnt++;
        }
        
        return;
    }
    
    dfs(numbers, idx+1, result + numbers[idx], target);
    dfs(numbers, idx+1, result - numbers[idx], target);
}