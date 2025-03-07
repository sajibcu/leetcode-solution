class Solution {
    public int[] closestPrimes(int left, int right) {

        List<Integer> primes = getPrime(left, right);

        int a = -1, b=-1;
        int min = right;
        for(int i=1;i<primes.size(); i++) {
            if(primes.get(i) - primes.get(i-1) < min ) {
                min = primes.get(i) - primes.get(i-1);
                a = primes.get(i-1);
                b = primes.get(i);
            }
        }

        return new int[]{a,b};
    }

    public List<Integer> getPrime( int left, int n) {
       boolean[] isPrime = new boolean[n+1];
       Arrays.fill(isPrime, true);
       isPrime[0] = isPrime[1] = false;
       // fill( isPrime , 2);

       for(int i = 2; i * i <=n ;i ++) {
            if( isPrime[i] )
                fill( isPrime, i);
       }
       List<Integer> prime = new ArrayList<>();
       for(int i = left; i<=n ;i ++) {
        //System.out.println(i + "##" + isPrime[i]);
            if( isPrime[i]) prime.add(i);
       }

       return prime;
       
    }

    public void fill(boolean[] isPrime, int n) {
        if (n * n >= isPrime.length) return;
        for(int i = n*n; i<isPrime.length; i +=n) {
           isPrime[i] = false; 
        }
    }
}