class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] less = new int[nums.length];
        int lessIndex = 0;
        int numOfPivot = 0;
        int[] greater = new int[nums.length];
        int greaterIndex = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] < pivot){
                less[lessIndex++] = nums[i];
            }
            else if(nums[i] == pivot){
                numOfPivot++;
            }
            else{
                greater[greaterIndex++] = nums[i];
            }
        }
        int index = 0;
        for(int i=0;i<lessIndex;i++){
            nums[index++] = less[i];
        }

        for(int i=0;i<numOfPivot ; i++){
            nums[index++] = pivot;
        }

        for(int i=0; i<greaterIndex; i++){
            nums[index++] = greater[i];
        }

        return nums;
    }
}