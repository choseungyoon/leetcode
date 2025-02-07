class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        result = 0
        dic = {}

        for i in range(0,len(nums)):
            for j in  range(i+1,len(nums)):
                val = nums[i]*nums[j]
                if val in dic:
                    dic[val] = dic[val] + 1
                else:
                    dic[val] = 1

        for key,value in dic.items() :
            if value > 1:
                result = result + 8 * (((value-1)*value) / 2)

        return int(result)