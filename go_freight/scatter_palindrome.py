def scatterPalindromeCount(s):
    def canFormPalindrome(s):
        sDict = {}
        for c in s:
            if c in sDict:
                sDict[c] += 1
            else:
                sDict[c] = 1

        a = [v for v in sDict.values() if v % 2]
        return len([v for v in sDict.values() if v % 2]) <= 1

    count = 0
    for i in range(len(s)):
        for j in range(i+1, len(s)+1):
            if canFormPalindrome(s[i:j]):
                count += 1
    return count


if __name__ == "__main__":
    print(scatterPalindromeCount("aabb"))
