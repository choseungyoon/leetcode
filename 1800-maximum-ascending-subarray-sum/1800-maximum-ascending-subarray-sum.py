class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        
        maxSum = nums[0]
        tempSum = nums[0]
        for i in range(1,len(nums)):
            if nums[i] > nums[i-1]:
                tempSum = tempSum + nums[i]
            else:
                tempSum = nums[i]
            
            if tempSum > maxSum:
                maxSum = tempSum
        
        return maxSum