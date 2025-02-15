class Solution {

    public boolean isPunishment(int current , int purpose){
        int divide = 10;
        int first  = current / divide;
        int second  = current % divide;

        while(first > 0){
            if (first + second == purpose) return true;
            else if (purpose-first > 0) {
                if(isPunishment(second, purpose - first)) return true;
            }

            divide *= 10;
            first = current / divide;
            second = current % divide;

        }

        return false;
    }

    public int punishmentNumber(int n) {
        int result = 1;

        for(int i = 2 ; i <= n ; i++){
            if(isPunishment(i*i,i)) result += i*i;
        }

        return result;
    }
}