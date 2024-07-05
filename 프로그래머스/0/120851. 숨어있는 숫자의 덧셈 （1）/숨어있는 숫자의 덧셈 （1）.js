function solution(my_string) {
    const answer = my_string.split("").filter((v) => !isNaN(v)).reduce((acc, cur) => acc + Number(cur), 0);
    return answer;
}