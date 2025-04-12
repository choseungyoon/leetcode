class Solution {

    private int isOddNumberOfDigit(int value){
        int digit = 0;

        while(value > 0){
            value = value / 10;
            digit++;
        }

        return digit;

    }

    private int sumOfDigit(int value){
        int sum = 0;

        while(value != 0){
            sum += value%10;
            value /= 10;
        }

        return sum;
    }

    private boolean isSymmetric(int value){

        int digit = isOddNumberOfDigit(value);
        if(digit % 2 == 1) return false;

        int first = sumOfDigit((int) (value % Math.pow(10,digit/2)));
        int second = sumOfDigit((int) (value / Math.pow(10,digit/2)));

        return first == second;

    }

    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        for(int i=low ; i<=high ; i++){
            if(isSymmetric(i)) {
                ans++;
            }
        }

        return ans;

    }

}