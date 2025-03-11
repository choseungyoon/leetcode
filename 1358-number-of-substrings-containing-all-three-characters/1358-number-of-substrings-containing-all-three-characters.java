class Solution {
  public int numberOfSubstrings(String s) {
    // s = ababbbc

    HashMap<Character,Integer> hm = new HashMap<>();

    int start = 0;
    int end = 0;
    int ans = 0;

    while(end < s.length()){
      char current = s.charAt(end);
      hm.put(current, hm.getOrDefault(current,0) + 1 );

      
      while(hm.size()>2){
        ans = ans + s.length() - end;

        char startChar = s.charAt(start);
        hm.put(startChar, hm.getOrDefault(startChar,0)-1);
        if(hm.get(startChar) == 0){
          hm.remove(startChar);
        }
        start++;

      }
      end++;
    }

    return ans;

  }
}