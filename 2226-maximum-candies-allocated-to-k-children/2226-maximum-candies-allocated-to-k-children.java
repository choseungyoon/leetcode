class Solution {
  int ans;
  long k;

  public int maximumCandies(int[] candies, long k) {
    this.ans = 0;
    this.k = k;

    int min = 1;
    int max = 0;

    // Find min value(can be max for answer)
    for(int i=0 ; i < candies.length ; i++){
      if(candies[i] > max) {
        max = candies[i];
      }
    }

    bSearch(candies,min,max);

    return this.ans;

  }

  public void bSearch(int[] candies, int first, int end){
    if(!check(candies,first)) {return;}
    if(check(candies,end)) {
      this.ans = end;
      return;
    }

    int mid = (first+end)/2;
    if (mid == first) return;

    if(check(candies,mid)){
      bSearch(candies,mid,end);

    }
    else{
      bSearch(candies,first,mid);
    }
  }

  public boolean check(int[] candies , int pile){
    long sum = 0L;
    for(int i=0; i < candies.length ; i++){
      sum += candies[i] / pile;

      if(sum >= this.k){
        if(this.ans < pile){
          this.ans = pile;
        }
        
        return true;
      }
    }
    return false;
  }

}