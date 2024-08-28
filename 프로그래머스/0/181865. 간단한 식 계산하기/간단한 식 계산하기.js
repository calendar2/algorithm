function solution(binomial) {
    var answer = 0;
    const equation = binomial.split(' ');
    
    switch (equation[1]) {
        case '+' :
            answer = Number(equation[0]) + Number(equation[2]);
            break;
        case '-' :
            answer = Number(equation[0]) - Number(equation[2]);
            break;
        case '*' :
            answer = Number(equation[0]) * Number(equation[2]);
            break;
    }
    
    return answer;
}