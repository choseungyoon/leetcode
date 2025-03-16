class Solution {

  public long repairCars(int[] ranks, int cars) {
    long minRanks = 101;

    for(int mechanic : ranks){
      if(mechanic < minRanks){
        minRanks = mechanic;
      }
      if(minRanks == 1) break;
    }

    long leftTime = 1;
    long rightTime =  minRanks * cars * cars;
    long ans = rightTime;
    long midTime = (leftTime + rightTime) / 2;

    while(leftTime < rightTime){

      if(check(midTime,ranks,cars)){
        // mid가 가능하면 더 낮은것으로 탐색
        ans = midTime;
        rightTime = midTime;
        midTime = (leftTime + rightTime) / 2;

      }
      else{
        leftTime = midTime;
        midTime = (leftTime + rightTime) / 2;
        if(leftTime == midTime) break;
      }
    }

    return ans;
  }


    public boolean check(long time, int[] ranks, int cars){

    int possibleCar = 0;

    for(int rank : ranks){
      possibleCar += (int)Math.sqrt((double) time /rank);
      if(possibleCar >= cars) return true;
    }
    return false;
  }

}