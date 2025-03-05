class Solution {
    public long coloredCells(int n) {
        // 1
        // 1 + 4
        // 1 + 4 + 8
        // 1 + 4 + 8 + 12 

        int index = 1;
        long result = 1;
        while(index < n){
            result += 4 * (index);
            index++;
        }

        return result;
    }
}