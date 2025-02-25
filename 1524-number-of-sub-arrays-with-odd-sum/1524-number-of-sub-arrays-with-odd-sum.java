class Solution {
       public int numOfSubarrays(int[] arr) {
        int result = 0;
        int[] accumulateSum = new int[arr.length+1];
        int[] evens = new int[arr.length+1];
        int[] odds = new int[arr.length+1];

        // 누적합 계산
        for(int i = 0 ; i< arr.length ; i++){
            if(i==0) accumulateSum[i] = arr[i];
            else accumulateSum[i] = arr[i] + accumulateSum[i-1];

            if(accumulateSum[i] % 2 == 0){
                if(i==0) evens[i] = 1;
                else {
                    evens[i] = evens[i-1] + 1;
                    odds[i] = odds[i-1];
                }
            }
            else{
                if(i==0) odds[i] = 1;
                else {
                    odds[i] = odds[i-1] + 1;
                    evens[i] = evens[i-1];
                }
            }
        }

        for(int i=0;i<arr.length ; i++){
            if(accumulateSum[i] % 2 == 0){
                if(i ==0 ) continue;
                result = (result + odds[i-1]) % 1000000007;
            }
            else{
                if(i==0) result = result + 1;
                else result = (result + 1 + evens[i-1])% 1000000007;
            }
        }

        return result % 1000000007;

    }
}