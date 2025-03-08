class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = blocks.length();
        // first backtrack all
        for(int i = 0 ; i< blocks.length() ; i++){
            int cnt = 0;
            if(blocks.charAt(i) == 'W') cnt++;
            if(i+k-1<blocks.length()){
                // i = 0
                // j = 1
                // i+k = 7
                for(int j=i+1; j<i+k ; j++){
                    if(blocks.charAt(j) == 'B') continue;
                    else cnt++;
                }

                if(cnt < ans) ans = cnt;
            }
        }

        return ans;
    }
}