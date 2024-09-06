function solution(arr, delete_list) {
    var answer = [];
    
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < delete_list.length; j++) {
            if (delete_list[j] === arr[i]) {
                break;
            }
            
            if (j === delete_list.length-1) {
                answer.push(arr[i]);
            }
        }
    }
    
    return answer;
}