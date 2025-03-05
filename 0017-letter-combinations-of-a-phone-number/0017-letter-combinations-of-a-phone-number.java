class Solution {

    public List<String> letterCombinations(String digits) {
    List<String> answer = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    // 초기화
    Map<Integer,String> map = new HashMap<>();
    map.put(2,"abc");
    map.put(3,"def");
    map.put(4,"ghi");
    map.put(5,"jkl");
    map.put(6,"mno");
    map.put(7,"pqrs");
    map.put(8,"tuv");
    map.put(9,"wxyz");

    // 문자열 만들기
    for(int i = 0 ; i< digits.length() ; i++){

      int key = digits.charAt(i) - '0';
      String value = map.get(key);

      for(int j=0;j < value.length();j++){
        if(i == 0){
          temp.add(Character.toString(value.charAt(j)));
        }
        else{
          for(String val : answer){
            temp.add(val + Character.toString(value.charAt(j)));
          }
        }
      }
      answer.clear();
      answer.addAll(temp);
      temp.clear();

    }

    return answer;

  }
}