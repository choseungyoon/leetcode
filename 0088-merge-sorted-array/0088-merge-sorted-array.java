class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n+1];

        int idx1 = 0;
        int idx2 = 0;
        int cur = 0;

        do {
            if(idx1 < m && idx2 < n && nums1[idx1] <= nums2[idx2]){
                result[cur] = nums1[idx1];
                idx1 = idx1 + 1;
            }
            else if (idx1 < m && idx2 < n && nums1[idx1] > nums2[idx2]){
                result[cur] = nums2[idx2];
                idx2 = idx2 + 1;
            }
            else if(idx1 >= m && idx2 < n){
                result[cur] = nums2[idx2];
                idx2 = idx2 + 1;
            }
            else if(idx2 >=n && idx1 < m){
                result[cur] = nums1[idx1];
                idx1 = idx1 + 1;
            }
            cur = cur+1;

        }while(idx1 < m || idx2  < n);


        for(int i = 0; i < m+n ; i++){
            nums1[i] = result[i];
        }
    }
}