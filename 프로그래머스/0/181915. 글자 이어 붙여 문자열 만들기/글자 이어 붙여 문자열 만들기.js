function solution(my_string, index_list) {
    var answer = '';
    index_list.map((index) => answer += my_string[index]);
    return answer;
}