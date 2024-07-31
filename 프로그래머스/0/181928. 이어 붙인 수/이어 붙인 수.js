function solution(num_list) {
    let odd = '';
    let even = '';
    
    for (const num of num_list) {
        if (Number(num) % 2) {
            odd += num;
        } else {
            even += num;
        }
    }
    
    return Number(odd) + Number(even);
}