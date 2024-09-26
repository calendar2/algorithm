function solution(nums) {
    const choice_num = nums.length / 2;
    const set = new Set(nums);
    
    return Math.min(choice_num, set.size);
}