class Solution {

    public long countOfSubstrings(String word, int k) {
        long numVaildSubstrings = 0;
        int start = 0;
        int end = 0;

        HashMap<Character,Integer> vowelCount = new HashMap<>(); // 모음 갯수
        int consonantCount = 0; // 자음 갯수

        // 자음 index 구하기
        int[] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();

        for(int i = word.length()-1 ; i>=0 ; i--){
            nextConsonant[i] = nextConsonantIndex;
            if(!isVowel(word.charAt(i))){
                nextConsonantIndex = i;
            }
        }

        while(end < word.length()){
             char newLetter = word.charAt(end);

             if(isVowel(newLetter)){
                vowelCount.put(newLetter,vowelCount.getOrDefault(newLetter,0)+1);
             }
             else{
                consonantCount++;
             }

             while(consonantCount > k){
                char startLetter = word.charAt(start);
                if(isVowel(startLetter)){
                     vowelCount.put(startLetter,vowelCount.getOrDefault(startLetter,0) - 1);
                     if(vowelCount.get(startLetter) == 0){
                        vowelCount.remove(startLetter);
                     }
                }
                else{
                    consonantCount--;
                }
                start++;
             }

             while(start<word.length() && vowelCount.keySet().size() == 5 && consonantCount ==k){
                numVaildSubstrings += nextConsonant[end] - end;
                char startLetter = word.charAt(start);
                if(isVowel(startLetter)){
                    vowelCount.put(startLetter, vowelCount.get(startLetter) - 1);
                    if(vowelCount.get(startLetter) == 0){
                        vowelCount.remove(startLetter);
                     }
                }
                else{
                    consonantCount--;
                }
                start++;
             }
             end++;
        }


        return numVaildSubstrings;
    }
    
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}