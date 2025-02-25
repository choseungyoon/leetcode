class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int all = 1;
        HashMap<Integer,Boolean> zeroMap = new HashMap();

        for(int i = 0; i< nums.length ; i++){
            if(nums[i] != 0){
                all *= nums[i];
            }
            else{
                zeroMap.put(i,true);
            }
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(zeroMap.size() > 0){
                if(nums[i] != 0){
                    result[i] = 0;
                }
                else{
                    if(zeroMap.size() > 1){
                        result[i] = 0;
                    }
                    else{
                        result[i] = all;
                    }
                }
                
            }
            else{
                result[i] = all / nums[i];
            }
        }
        
        return result;
    }
}