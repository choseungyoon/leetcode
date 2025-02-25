class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();

        int lenWord1 = word1.length();
        int lenWord2 = word2.length();
        int idx1 = 0;
        int idx2 = 0;
        do {
            if(idx1 < lenWord1){
                builder.append(word1.charAt(idx1));
                idx1++;
            }

            if(idx2 < lenWord2){
                builder.append(word2.charAt(idx2));
                idx2++;
            }

        }while(idx1 < lenWord1 | idx2 < lenWord2);

        System.out.println(builder);
        return builder.toString();
    }
}