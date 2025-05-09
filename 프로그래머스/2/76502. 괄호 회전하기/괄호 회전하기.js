function solution(s) {
    var answer = 0;
    const arr = s.split('');
    const len = arr.length;
    
    for (let i = 0; i < len; i++) {
        const temp = arr.shift();
        arr.push(temp);
        const isPossible = check(arr, len);
        
        if (isPossible) {
            answer += 1;
        }
    }
    
    return answer;
}

function check(arr, len) {
    const stack = [];
    
    for (let i = 0; i < len; i++) {
        const element = arr[i];
        
        if (element === '(' || element === '[' || element === '{') {
            stack.push(element);
        } else {
            if (stack.length === 0) {
                return false;
            }
            
            const temp = stack.pop();
            
            if (temp === '(' && element !== ')') {
                return false;
            } else if (temp === '[' && element !== ']') {
                return false;
            } else if (temp === '{' && element !== '}') {
                return false;
            }
            
//             while (true) {
//                 if (stack1.length === 0) {
//                     return false;
//                 }
                
//                 const temp = stack1.pop();
                
//                 if (temp === '(') {
//                     if (element === ')') {
//                         break;
//                     } else if (element === ']' || element === '}') {
//                         return false;
//                     }
//                 } else if (temp === '[') {
//                     if (element === ']') {
//                         break;
//                     } else if (element === ')' || element === '}') {
//                         return false;
//                     }
//                 } else if (temp === '{') {
//                     if (element === '}') {
//                         break;
//                     } else if (element === ']' || element === ')') {
//                         return false;
//                     }
//                 } else {
//                     stack2.push(element);
//                     element = temp;
//                 }
//             }
        }
    }
    
    if (stack.length === 0) {
        return true;
    } else {
        return false;
    }
}