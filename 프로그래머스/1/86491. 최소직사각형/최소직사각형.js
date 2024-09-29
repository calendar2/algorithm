function solution(sizes) {
    let width_max = 0;
    let height_max = 0;
    
    for (const size of sizes) {
        const width = Math.max(size[0], size[1]);
        const height = Math.min(size[0], size[1]);
        
        if (width > width_max) {
            width_max = width;
        }
        
        if (height_max < height) {
            height_max = height;
        }
    }
    
    return width_max * height_max;
}