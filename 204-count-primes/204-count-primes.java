class Solution {
    public int countPrimes(int n) {
        
        //sieve of eratosthenes
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        if(primes.length >= 2) {
            primes[1] = false;
        }
        int count = 0;
        
        for(int i = 2; i < n; i++) {
            if(primes[i]) {
                count++;
                for(int j = 2 * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return count;
    }
}