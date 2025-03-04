func checkPowersOfThree(n int) bool {
    threePow := 4782969 // 3^14 = 4782969

    for threePow > 0 {
        if threePow <= n {
            n -= threePow
        }
        threePow /= 3
    }
    return n == 0
    
}