function solution(myString) {
    const arr = myString.split('');
    
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === 'a' || arr[i] === 'A') {
            arr[i] = 'A';
        } else {
            arr[i] = arr[i].toLowerCase();
        }
    }
    
    return arr.join('');
}