class Solution {
    public boolean isSubsequence(String s, String t) {

        int idx = -1;

        for(int i = 0 ; i < s.length() ; i++){
            int result = t.indexOf(s.charAt(i),idx+1);
            System.out.println("=====");
            System.out.println("char : " + s.charAt(i));
            System.out.println("result : " + result);

            if(result != -1){
                idx = result;
            }
            else{
                return false;
            }
        }

        return true;
    }
}