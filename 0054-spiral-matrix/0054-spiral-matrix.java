class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        int[][] visited = new int[matrix.length][matrix[0].length];

        int curX = 0;
        int curY = 0;

        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;

        for (int i = 0 ;i < matrix.length ; i++){
            for (int j = 0;  j < matrix[0].length ; j++){
                visited[i][j] = 0;
            }
        }


        do {
            if(curX >= matrix.length || curX < 0 || curY >= matrix[0].length || curY < 0 || visited[curX][curY] == 1) {
                break;
            }

            result.add(matrix[curX][curY]);
            visited[curX][curY] = 1;

            if(right){
                // right
                if(curY + 1 < matrix[0].length && visited[curX][curY+1] == 0){
                    curY++;
                }
                else{
                    right = false;
                    down = true;
                    curX++;
                }
            }
            else if(down){
                // down
                if(curX + 1 < matrix.length && visited[curX+1][curY] == 0){
                    curX++;
                }
                else{
                    down = false;
                    left = true;
                    curY--;
                }
            }
            else if(left){
                // left
                if(curY - 1 >= 0 && visited[curX][curY-1] == 0){
                    curY--;
                }
                else{
                    left = false;
                    up = true;
                    curX--;
                }
            }
            else if(up){
                // up
                if(curX - 1 >= 0 && visited[curX-1][curY] == 0){
                    curX--;
                }
                else{
                    up = false;
                    right = true;
                    curY++;
                }
            }
            else{
                System.out.println("HERE 2");
                break;
            }

        }while(true);

        return result;
    }
}