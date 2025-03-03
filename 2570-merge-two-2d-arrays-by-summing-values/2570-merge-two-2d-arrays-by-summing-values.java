class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        int idx1 = 0;
        int idx2 = 0;

        do {
            if(idx1 < nums1.length && idx2 < nums2.length){
                if(nums1[idx1][0] < nums2[idx2][0]){
                    if(hm.containsKey(nums1[idx1][0])){
                        hm.put(nums1[idx1][0], hm.get(nums1[idx1][0]) + nums1[idx1][1]);
                    }
                    else{
                        hm.put(nums1[idx1][0],nums1[idx1][1]);
                    }
                    idx1++;
                }
                else{
                    if(hm.containsKey(nums2[idx2][0])){
                        hm.put(nums2[idx2][0], hm.get(nums2[idx2][0]) + nums2[idx2][1]);
                    }
                    else{
                        hm.put(nums2[idx2][0],nums2[idx2][1]);
                    }
                    idx2++;
                }
                System.out.println(hm);
            }
            else{
                if(idx1 < nums1.length){
                    if(hm.containsKey(nums1[idx1][0])){
                        hm.put(nums1[idx1][0], hm.get(nums1[idx1][0]) + nums1[idx1][1]);
                    }
                    else{
                        hm.put(nums1[idx1][0],nums1[idx1][1]);
                    }
                    idx1++;
                }
                else if(idx2 < nums2.length){
                    if(hm.containsKey(nums2[idx2][0])){
                        hm.put(nums2[idx2][0], hm.get(nums2[idx2][0]) + nums2[idx2][1]);
                    }
                    else{
                        hm.put(nums2[idx2][0],nums2[idx2][1]);
                    }
                    idx2++;
                }
            }
        }while(idx1 < nums1.length || idx2 < nums2.length);

        int idx = 0;
        int[][] ans = new int[hm.size()][2];

        ArrayList<Integer> keySet = new ArrayList<>(hm.keySet());
        Collections.sort(keySet);

        for (Integer key : keySet) {
        ans[idx][0] = key;
        ans[idx++][1] = hm.get(key);
        }

        return ans;
    }
}