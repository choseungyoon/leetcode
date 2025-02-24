class Solution {
        boolean[] visited = new boolean[10];

    private StringBuilder sequence = new StringBuilder();

    private String pattern;

    private String answer;

    public void backTracking(int position){
        if(answer != null){
            return;
        }

        if(position == pattern.length() + 1){
            answer = sequence.toString();
            return;
        }

        for(int i = 1; i< 10 ;i++){
            if(!visited[i]){

                if(position > 0 && pattern.charAt(position-1) == 'I' && sequence.charAt(position-1) - '0' >= i){
                    continue;
                }

                if(position > 0 && pattern.charAt(position-1) == 'D' && sequence.charAt(position -1 ) - '0' <= i){
                    continue;
                }

                visited[i] = true;
                sequence.append(i);
                backTracking(position+1);
                sequence.deleteCharAt(sequence.length()-1);
                visited[i] = false;
            }
        }
    }
    public String smallestNumber(String pattern) {
        this.pattern = pattern;
        backTracking(0);
        return answer;
    }


}