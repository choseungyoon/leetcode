class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        // 변수 선언 및 초기화
        int n = grid.length;
        boolean[] checked = new boolean[n*n+1]; // 50^2 = 2500
        int[] ans = new int[2];


        // n^2 탐색
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int value = grid[i][j];
                if(!checked[value]) checked[value] = true;
                else ans[0] = value;

            }
        }

        for(int i = 1 ; i < n*n+1;i++){
            if(!checked[i]){
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}