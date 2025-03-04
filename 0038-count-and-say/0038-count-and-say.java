class Solution {
    public String countAndSay(int n) {
        String str = "";

        String rle = "1";
        int repeat = 1;

        while(repeat < n){
            for(int i = 0 ; i < rle.length() ; i++){
                char t = rle.charAt(i);
                int j = i+1;
                while(j < rle.length() && t == rle.charAt(j)) j++;
                str = str + String.valueOf(j-i) + String.valueOf(t);
                i = j-1;
                
            }
            rle = str;
            str = "";
            repeat++;
        }

        return rle;
    }
}