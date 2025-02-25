class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = (int)Math.pow(2, 31) ;
        int second =(int)Math.pow(2, 31) ;
        System.out.println("first : " + first);
        System.out.println("second : " + second);
        System.out.println("=====");
        for(int i=0 ; i< nums.length ; i++){
            if(nums[i] <= first){
                first = nums[i];
            }
            else if(nums[i] <= second){
                second = nums[i];
            }
            else{
                System.out.println("first : " + first);
                System.out.println("second : " + second);
                System.out.println("nums[i] : " + nums[i]);
                return true;
            }
        }
        return false;
    }
}