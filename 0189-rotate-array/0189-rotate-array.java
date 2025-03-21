class Solution {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums,0,nums.length-1); // 7 6 5 4 3 2 1
        reverse(nums,0,k-1); // 
        reverse(nums,k,nums.length-1);
        System.gc();
    }

    public void reverse(int[] nums , int start, int end){

        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}