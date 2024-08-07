function solution(my_string, is_suffix) {
    const len = is_suffix.length;
    return my_string.slice(-len) === is_suffix ? 1 : 0;
}