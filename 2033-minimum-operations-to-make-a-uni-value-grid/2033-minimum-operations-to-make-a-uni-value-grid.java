class Solution {
    public int minOperations(int[][] grid, int x) {

        ArrayList<Integer> arr = new ArrayList<>();
        int ans = 0;

        for(int row  = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[row].length ; col++){
                arr.add(grid[row][col]);
            }
        }

        int reminder = arr.get(0) % x;
        for(int val : arr){
            if(reminder != (val % x)) return -1;
        }

        Collections.sort(arr);

        int median = arr.get(arr.size()/2);

        for(int val : arr){
            ans += (Math.abs(val-median)/x);
        }

        return ans;
    }
}