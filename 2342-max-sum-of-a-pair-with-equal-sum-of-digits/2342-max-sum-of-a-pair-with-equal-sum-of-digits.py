class Solution:
    
    def sumOfDegit(self,num:int) -> int:
        sum = 0
        while num > 0 :
            sum = sum + (num%10)
            num = num // 10
        
        return sum
           
        
    def maximumSum(self, nums: List[int]) -> int:
        solution = Solution()
        result = -1
        hashDigit = {}
        
        for i in nums:
            digitSum = solution.sumOfDegit(i)
            
            if digitSum not in hashDigit:
                hashDigit[digitSum] = {'top1': None, 'top2': None}
                
            current = hashDigit[digitSum]
            
            if current['top1'] is None or i > current['top1']:
                current['top2'] = current['top1']
                current['top1'] = i
            elif current['top2'] is None or i > current['top2']:
                current['top2'] = i
            
            if current['top1'] is not None and current['top2'] is not None and current['top1']  + current['top2'] > result:
                result = current['top1']  + current['top2']

        return result