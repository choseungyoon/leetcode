class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        incLen = 1
        decLen = 1
        incTemp = 1
        decTemp = 1

        for i in range(1,len(nums)):
            if nums[i-1] < nums[i]:
                incTemp = incTemp + 1
                if incTemp > incLen:
                    incLen = incTemp
            else:
                incTemp = 1
            
            if nums[i-1] > nums[i]:
                decTemp = decTemp + 1
                if decTemp > decLen:
                    decLen = decTemp
            else:
                decTemp = 1
        
        return  incLen if incLen > decLen else decLen


        