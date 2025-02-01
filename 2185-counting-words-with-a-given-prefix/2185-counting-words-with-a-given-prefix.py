class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        num = 0
        for word in words:
            if word.startswith(pref):
                num = num + 1
        return num