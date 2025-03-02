import java.util.regex.Pattern;

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> answers = new ArrayList<String>();

            for(String word : words){
      for(String w : word.split(Pattern.quote(String.valueOf(separator)))){
        if(!w.trim().isEmpty()) answers.add(w.trim());
      }
    }


        return answers;
    }

}