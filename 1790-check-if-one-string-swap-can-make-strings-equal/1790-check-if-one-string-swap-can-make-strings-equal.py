class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        
        if s1 == s2 :
            return True
        
        tempA = []
        tempB = []
        diff = 0
        for i in range(0,len(s1)):
            if s1[i] != s2[i]:
                diff = diff + 1
                tempA.append(s1[i])
                tempB.append(s2[i])

                if diff > 2 :
                    return False
        
        if diff % 2 == 1:
            return False
            
        if tempA[0] == tempB[1] and tempA[1] == tempB[0]:
            return True
        else:
            return False