function checkPowersOfThree(n: number): boolean {
    let threePow = 4782969; // 3^14 = 4782969

    while (threePow > 0) {
        if (threePow <= n) {
            n -= threePow;
        }
        threePow = Math.floor(threePow / 3);
    }

    return n === 0;
    
};