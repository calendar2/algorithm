function solution(id_pw, db) {
    var answer = 'fail';
    
    for (const data of db) {
        if (id_pw[0] === data[0]) {
            if (id_pw[1] === data[1]) {
                answer = 'login';
                break;
            } else {
                answer = 'wrong pw';
            }
        }
    }
    
    return answer;
}