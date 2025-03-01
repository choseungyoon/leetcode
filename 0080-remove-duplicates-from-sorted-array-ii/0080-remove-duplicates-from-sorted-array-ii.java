class Solution {
    public int removeDuplicates(int[] nums) {
        int[] result = new int[nums.length];
        int [] checked = new int[10000*2+2];
        int idx = 0;

        for(int i = 0 ; i<nums.length ; i++){
            if(checked[nums[i]+10000] < 2){
                result[idx++] = nums[i]; 
                checked[nums[i]+10000]++;
            }
        }

        for(int i = 0 ; i < idx ; i++){
            nums[i] = result[i];
        }

        return idx--;
    }
}