class Solution {

   public boolean canLocation(int n , int start, int end, int[] result, int[] isUsed){
        int current = 0;
        int isFinished = 0;
        for (int i = n ; i >= 1 ;i--) {
            if(isUsed[i] == 0){
                current = i;
                break;
            }
            else{
                isFinished++;
            }

            if(isFinished ==n){
                return true;
            }
        }

        for (int i = current ; i >= 1 ; i --){
            boolean flag = false;
            if(isUsed[i] == 1) continue;
            if(i==1 && result[start] == 0){
                // condition 1
                result[start] = i;
                isUsed[i] = 1;
                flag = true;
            }
            else if(result[start] == 0 && start+i <= end && result[start+i] == 0){
                // condition 2
                result[start] = i;
                result[start+i] = i;
                isUsed[i] = 1;
                flag = true;
            }

            if(flag){
                int nextStep = 0;
                for(int j = start + 1; j<=end ; j++){
                    if(result[j] == 0) {
                        nextStep = j;
                        break;
                    }
                }

                if(canLocation(n,nextStep,end,result,isUsed)){
                    return true;
                }
                else{
                    if(i == 1){
                        result[start] = 0;
                    }
                    else{
                        result[start] = 0;
                        result[start+i] = 0;
                    }

                    isUsed[i] = 0;
                }
            }
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int maxLen = (n-1) * 2 + 1;

        int[] result= new int[maxLen];
        int[] isUsed = new int[n+1];

        canLocation(n,0,maxLen-1,result,isUsed);
        return result;
    }

}