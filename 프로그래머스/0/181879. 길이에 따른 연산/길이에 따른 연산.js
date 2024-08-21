function solution(num_list) {
    const len = num_list.length;
    let bool = false;
    
    if (len >= 11) {
        bool = true;
    }
    
    return bool ? num_list.reduce((acc, cur) => acc + cur, 0) : num_list.reduce((acc, cur) => acc * cur, 1);
}