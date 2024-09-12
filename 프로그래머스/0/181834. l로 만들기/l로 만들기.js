function solution(myString) {
    return myString.split('').map(s => s.charCodeAt() < 'l'.charCodeAt() ? 'l' : s).join('');
}