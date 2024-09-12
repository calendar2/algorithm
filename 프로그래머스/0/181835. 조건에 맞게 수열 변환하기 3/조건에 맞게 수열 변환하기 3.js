function solution(arr, k) {
    return k % 2 ? arr.map(a => a * k) : arr.map(a => a + k);
}