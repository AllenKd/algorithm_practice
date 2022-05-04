def countBinarySubstrings(s):
    s = [len(l) for l in s.replace('01', '0 1').replace('10', '1 0').split()]
    return sum(min(a, b) for a, b in zip(s, s[1:]))


if __name__ == "__main__":
    print(countBinarySubstrings("001110011"))
    print(countBinarySubstrings("10101"))
