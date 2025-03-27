class Solution {

    public int minimumIndex(List<Integer> nums) {

        HashMap<Integer,Integer> first = new HashMap<>();
        HashMap<Integer,Integer> second = new HashMap<>();
        int firstLen = 0;
        int secondLen = nums.size();

        for(int val : nums){
            second.put(val,second.getOrDefault(val,0) + 1 );
        }

        for(int i = 0 ; i < nums.size() ; i++){
            int val = nums.get(i);

            first.put(val,first.getOrDefault(val,0)+1);
            second.put(val,second.get(val)-1);
            firstLen++;
            secondLen--;
            if(second.get(val) == 0 ) second.remove(val);

            int countInFirst = first.get(val);
            int countInSecond = second.getOrDefault(val,0);

            if((countInFirst * 2 > firstLen) && (countInSecond * 2 > secondLen)) return i;

        }

        return -1;
    }
}