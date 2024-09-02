function solution(arr1, arr2) {
    var answer = 0;
    
    if (arr1.length > arr2.length) {
        answer = 1;
    } else if (arr1.length < arr2.length) {
        answer = -1;
    } else {
        const num1 = arr1.reduce((acc, cur) => acc + cur, 0);
        const num2 = arr2.reduce((acc, cur) => acc + cur, 0);
        
        if (num1 > num2) {
            answer = 1;
        } else if (num1 < num2) {
            answer = -1;
        }
    }
    
    return answer;
}