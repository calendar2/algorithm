function solution(ineq, eq, n, m) {
    if (n === m) {
        if (eq === '=') {
            return 1;
        } else {
            return 0;
        }
    } else if (n > m) {
        if (ineq === '>') {
            return 1;
        } else {
            return 0;
        }
    } else {
        if (ineq === '<') {
            return 1;
        } else {
            return 0;
        }
    }
}