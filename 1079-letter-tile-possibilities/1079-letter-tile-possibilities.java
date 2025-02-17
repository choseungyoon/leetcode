class Solution {
    
    int result = 0;

    public void dfs(HashMap<Character,Integer> hm ,  String str){

        for (Character i : hm.keySet()){

            if (hm.get(i) < 1) {
                continue;
            }

            str = str + i;
            result = result + 1;

            hm.replace(i,hm.get(i)-1);
            dfs(hm,str);
            hm.replace(i,hm.get(i)+1);
            str = str.substring(0,str.length()-1);
        }
    }

    public int numTilePossibilities(String tiles) {

        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        
        for (int i=0 ; i< tiles.length();i++){
            if (hm.containsKey(tiles.charAt(i))){
                int value = hm.get(tiles.charAt(i));
                hm.replace(tiles.charAt(i),value+1);
            }
            else{
                hm.put(tiles.charAt(i),1);
            }
        }
        dfs(hm,"");

        System.out.println(result);
        return result;
    }
}