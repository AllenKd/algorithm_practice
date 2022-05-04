def minimalOperations(words):
    def min_substi(word):
        n = len(word)
        if n <= 1:
            return 0
        i = 0
        j = 1
        ans = 0
        while j < n:
            if word[i] == word[j]:
                j += 1
            else:
                # increment ans
                length = j - (i + 1) + 1
                ans += length // 2

                # iterate
                i = j
                j = i + 1

        # increment ans
        length = j - (i + 1) + 1
        ans += length // 2

        return ans

    return [min_substi(word) for word in words]


if __name__ == "__main__":
    minimalOperations(["add", "boooksss", "breaks"])
