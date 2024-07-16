let visited = [false, false, false, false];
let answer = 0;
let static_dots = [];

function solution(dots) {
    for (let i = 0; i < 4; i++) {
        static_dots.push(dots[i]);
    }
    
    comb(4, 0, 2);
    return answer;
}

const comb = (n , start, r) => {
    if (r === 0) {
        let visit_temp = [];
        let temp = [];
        
        for (let i = 0; i < 4; i++) {
            if (visited[i]) {
                visit_temp.push(static_dots[i]);
            } else {
                temp.push(static_dots[i]);
            }
        }
        
        let visit_distance = [visit_temp[1][0] - visit_temp[0][0], visit_temp[1][1] - visit_temp[0][1]];
        let distance = [temp[1][0] - temp[0][0], temp[1][1] - temp[0][1]];
        
        if (visit_distance[1] / visit_distance[0] === distance[1] / distance[0]) {
            answer = 1;
        }
    }
    
    for (let i = start; i < n; i++) {
        visited[i] = true;
        comb(n, i+1, r-1);
        visited[i] = false;
    }
}