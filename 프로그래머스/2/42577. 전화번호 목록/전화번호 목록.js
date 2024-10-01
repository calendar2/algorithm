function solution(phone_book) {
    var answer = true;
    const len = phone_book.length;
    phone_book.sort();
    
    for (let i = 0; i < len-1; i++) {
        const head = phone_book[i];
        const head_len = head.length;
        const temp = phone_book[i+1].slice(0, head_len);
        
        if (head === temp) {
            answer = false;
            break;
        }
    }
    
    return answer;
}