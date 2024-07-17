function solution(numlist, n) {
    var answer = [];
    const orderList = [];
    
    for (const num of numlist) {
        const temp = [num, Math.abs(num - n)];
        orderList.push(temp);
    }
    
    orderList.sort((a, b) => a[1] === b[1] ? b[0] - a[0] : a[1] - b[1]);
    for (const order of orderList) {
        answer.push(order[0]);
    }
    
    return answer;
}