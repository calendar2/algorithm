function solution(my_string, queries) {
    const my_arr = my_string.split('');
    
    for (const query of queries) {
        let left = query[0];
        let right = query[1];
        
        while (left < right) {
            const temp = my_arr[left];
            my_arr[left] = my_arr[right];
            my_arr[right] = temp;
            left++;
            right--;
        }
    }
    
    return my_arr.join('');
}