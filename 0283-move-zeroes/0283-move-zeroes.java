class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0 ; i< nums.length ; i++){
            if(nums[i] == 0){
                for(int j = i+1; j < nums.length ; j++){
                    if(nums[j] != 0){
                        // SWAP
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
    }
}