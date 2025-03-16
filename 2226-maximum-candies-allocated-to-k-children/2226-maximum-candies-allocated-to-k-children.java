class Solution {

    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 0;
        for (int candy : candies) {
            right = Math.max(right, candy); // 최대값 찾기
        }
        
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canDistribute(candies, k, mid)) {
                result = mid; // mid 값이 가능하면 더 큰 값 탐색
                left = mid + 1;
            } else {
                right = mid - 1; // mid 값이 불가능하면 줄임
            }
        }
        return result;
    }

    private boolean canDistribute(int[] candies, long k, int mid) {
        if (mid == 0) return false;
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
            if (count >= k) return true; // k 명에게 나눠줄 수 있으면 가능
        }
        return false;
    }

}