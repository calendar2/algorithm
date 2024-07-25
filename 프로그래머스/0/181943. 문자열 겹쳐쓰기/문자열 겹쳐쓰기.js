function solution(my_string, overwrite_string, s) {
    const length = overwrite_string.length;
    var answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s+length);
    return answer;
}