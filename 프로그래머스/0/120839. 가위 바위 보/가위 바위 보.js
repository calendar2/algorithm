function solution(rsp) {
    var answer = '';
    
    for (const a of rsp) {
        switch (a) {
            case '0' :
                answer += '5';
                break;
            case '2' :
                answer += '0';
                break;
            case '5' :
                answer += '2';
                break;
        }
    }
    
    return answer;
}