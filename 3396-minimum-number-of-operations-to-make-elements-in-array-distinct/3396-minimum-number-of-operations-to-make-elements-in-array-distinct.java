class Solution {
        public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        int idx = 0;

        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0) + 1);
        }

        while(true){
            if(hm.size() == (nums.length - idx)){
                break;
            }

            if(nums.length-idx < 3){
                ans++;
                break;
            }


                ans++;
                for(int i=0;i<3;i++){
                    hm.put(nums[idx],hm.get(nums[idx])-1);
                    if(hm.get(nums[idx]) == 0){
                        hm.remove(nums[idx]);
                    }
                    idx++;
                }


        }

        return ans;

    }
}