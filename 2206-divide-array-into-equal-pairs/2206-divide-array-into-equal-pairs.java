class Solution {
    public boolean divideArray(int[] nums) {
        
        int satisfiedPair = nums.length / 2;
        int currentPair = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length ; i++){
            int val = nums[i];

            if(hm.containsKey(val)){
                int value = hm.get(val);
                 currentPair++;
                 hm.remove(val);
            }
            else{
                hm.put(val,1);
            }
        }

        if(hm.size() == 0 && (currentPair == satisfiedPair)){
            return true;
        }
        else{
            return false;
        }
    }
}