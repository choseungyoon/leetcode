import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        int last = 0;
        int meetingDays = 0;
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0],b[0]));
        
        for(int[] meeting : meetings){
            int firstDay = meeting[0];
            int lastDay = meeting[1];
            
            if(last == 0){
                meetingDays += (lastDay - firstDay + 1);
                last = lastDay;
            }
            else{
                if(last < firstDay){
                    meetingDays += (lastDay - firstDay + 1);
                    last = lastDay;
                }
                else if(last < lastDay){
                    meetingDays += (lastDay - last);
                    last = lastDay;
                }
            }
            
        }
    
        return days - meetingDays;
    }
}