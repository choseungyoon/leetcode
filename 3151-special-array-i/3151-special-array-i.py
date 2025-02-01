class Solution:
 def isArraySpecial(self, nums: List[int]) -> bool:
        
        for i in range(len(nums)-1):
            current_value = nums[i]
            next_value = nums[i+1]
            
            if current_value % 2 == 0 and next_value % 2  == 1:
                continue
            elif current_value % 2 == 1 and next_value % 2  == 0:
                continue
            else :
                return False
            
        return True