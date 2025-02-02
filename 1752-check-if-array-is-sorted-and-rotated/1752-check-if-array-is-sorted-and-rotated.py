class Solution:
    def check(self, nums: List[int]) -> bool:
        
        sortedNum = sorted(nums)
        
        for i in range(0,len(nums)):
            deque_a = deque(nums)
            deque_a.rotate(i)
            if list(deque_a) == sortedNum:
                return True
        return False