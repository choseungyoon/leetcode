class Solution {

    public String find(String first , String second){
        int len = first.length();

        for(int i = 0; i < len ; i++){
            String subString = first.substring(0,len-i);
            if(first.replace(subString,"").isEmpty() && second.replace(subString,"").isEmpty()){
                return subString;
            }
        }
        
        return "";
    }

    public String gcdOfStrings(String str1, String str2) {
        
        int len1 = str1.length();
        int len2 = str2.length();

        if(len1 < len2){
            return find(str1,str2);
        }
        else{
            return find(str2,str1);
        }
    }
}