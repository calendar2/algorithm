function solution(my_string) {
    const answer = [...new Set(my_string.split(''))].reduce((acc, cur) => acc + cur, '');
    return answer;
}