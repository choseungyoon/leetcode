class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {

        Arrays.sort(rectangles, (a,b) -> Integer.compare(a[1],b[1]));

        // horizontal
        int lastLine = -1;
        int cnt = 0;
        for(int[] rectangle : rectangles){
            int startX = rectangle[0];
            int startY = rectangle[1];
            int endX = rectangle[2];
            int endY = rectangle[3];
            
            System.out.println(startX + " " + startY + " " + endX + " " + endY);

            if(lastLine == -1){
                lastLine = endY;
                cnt++;
            }
            else{
                if(startY < lastLine && lastLine < endY){
                    lastLine = endY;
                }
                else if(endY <= lastLine){
                    continue;
                }
                else if(startY >= lastLine){
                    cnt++;
                    lastLine = endY;
                }
                else{
                    System.out.println("HH!!!!");
                }
            }
        }

        if(cnt > 2) return true;

        // vertical
        Arrays.sort(rectangles, (a, b) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return Integer.compare(a[i], b[i]);
                }
            }
            return 0; // 모든 요소가 같을 때
        });
        lastLine = -1;
        cnt = 0;

        for(int[] rectangle : rectangles){
            int startX = rectangle[0];
            int startY = rectangle[1];
            int endX = rectangle[2];
            int endY = rectangle[3];
            
            //System.out.println(startX + " " + startY + " " + endX + " " + endY);

            if(lastLine == -1){
                lastLine = endX;
                cnt++;
            }
            else{
                if(startX < lastLine && lastLine < endX){
                    lastLine = endX;
                }
                else if(endX <= lastLine){
                    continue;
                }
                else if(startX >= lastLine){
                    cnt++;
                    lastLine = endX;
                }
                else{
                    System.out.println("lastLine : " + lastLine);
                    System.out.println("VV!!!!");
                }
            }
        }

        if(cnt > 2) return true;

        return false;
    }
}