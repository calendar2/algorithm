function solution(score) {
    var answer = new Array(score.length);
    const mean = [];
    
    for (let i = 0; i < score.length; i++) {
        const temp = [i, (score[i][0] + score[i][1]) / 2];
        mean.push(temp);
    }
    
    mean.sort((a, b) => a[1] === b[1] ? a[0] - b[0] : b[1] - a[1]);
    answer[mean[0][0]] = 1;
    let p_score = mean[0][1];
    let order = 1;
    let jump = 1;
    
    for (let i = 1; i < mean.length; i++) {
        if (p_score === mean[i][1]) {
            answer[mean[i][0]] = order;
            jump++;
        } else {
            order += jump;
            answer[mean[i][0]] = order;
            jump = 1;
            p_score = mean[i][1];
        }
    }
    
    return answer;
}