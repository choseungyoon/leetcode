class Solution {
    public String reverseWords(String s) {
        String[] stringArrays = s.trim().split(" ");
        StringBuilder builders = new StringBuilder();
        System.out.println(stringArrays.length);

        for(int i = stringArrays.length-1; i >=0 ; i--){
            if(stringArrays[i].isEmpty()) continue;
            builders.append(stringArrays[i]);
            if(i!=0)  builders.append(" ");

        }

        return builders.toString();
    }
}