class Solution {
    public int max(int a , int b){
        return a > b ? a : b;
    }

    public int maxSubArray(int[] nums) {
        int MaxValue = nums[0];
        int localMaxValue = nums[0];
        for(int i = 1;i<nums.length ; i++){

            localMaxValue = max(nums[i] , localMaxValue + nums[i]);
            MaxValue = max(localMaxValue,MaxValue);
        
        }

        return MaxValue;
    }
}