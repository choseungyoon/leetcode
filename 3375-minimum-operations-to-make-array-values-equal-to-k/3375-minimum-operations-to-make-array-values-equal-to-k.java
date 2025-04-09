class Solution {
    public int minOperations(int[] nums, int k) {

        // 목표 : 모든 수를 K로 만들 수 있으면 됨
        // 만들 수 없다면 -1 반환
        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            if(num < k){
                return -1;
            }
            else if(num > k){
                st.add(num);
            }
        }

        return st.size();
    }
}