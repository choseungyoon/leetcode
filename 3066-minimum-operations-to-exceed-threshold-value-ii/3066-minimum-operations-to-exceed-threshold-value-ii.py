class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        result = 0
        
        nums.sort()
        
        while nums[0] < k:
            x = nums[0]
            y = nums[1]
            del nums[0:2]
            bisect.insort(nums, min(x, y) * 2 + max(x, y))
            result = result + 1
        
        return result