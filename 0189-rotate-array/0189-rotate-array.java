class Solution {
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int idx = 0;
        k = k % nums.length;
        
        for(int i = nums.length - k  ; i<nums.length;i++){
            result[idx++] = nums[i];
        }

        for(int i = 0; i< nums.length-k ; i++)
        {
            result[idx++] = nums[i];
        }

        for(int i=0;i<nums.length ; i++){
            nums[i] = result[i];
        }
    }
}