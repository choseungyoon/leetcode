class Solution {
    public int maximumCount(int[] nums) {

        if(nums[0] > 0) return nums.length;
        else if(nums[nums.length-1] < 0) return nums.length;
        else if(nums[0] == 0) {
            int i = 0;
            while(nums[i] == 0 ){
                i++;
                if(i >= nums.length) return 0;
            }
            return nums.length - i;
        }
        else if(nums[nums.length-1] == 0){
            int i = 1;
            while(nums[nums.length-i] == 0){
                i++;
                if(nums.length-i<0) return 0;
            }

            return nums.length - i +1;
        }

        int zero = 0;
        int neg = 0;
        for(int i = 0;i < nums.length ; i++){
            if(nums[i]==0){
                zero++;
            }
            else if(nums[i] < 0){
                neg++;
            }
            else{
                return nums.length - zero - neg > neg ? nums.length - zero - neg : neg;
            }
        }

        return 0;
    }
}