function solution(my_string, s, e) {
    const arr = my_string.split('');
    let left = s;
    let right = e;
    
    while (left < right) {
        const temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
    
    return arr.join('');
}