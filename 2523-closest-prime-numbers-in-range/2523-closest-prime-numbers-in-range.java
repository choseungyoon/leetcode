class Solution {

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public int[] closestPrimes(int left, int right) {
        int[] ans = new int[2];
        int minimum = 1000001;
        int firstPrime = 0;

        for(int i=left;i<=right;i++){
            if(isPrime(i)){
                if(firstPrime == 0){
                    firstPrime = i;
                }
                else{

                    if(i - firstPrime < minimum){
                        ans[0] = firstPrime;
                        ans[1] = i;
                        minimum = i - firstPrime;
                    }
                    firstPrime = i;
                }
            }
        }

        return minimum == 1000001 ? new int[]{-1,-1} : ans;
    }
}