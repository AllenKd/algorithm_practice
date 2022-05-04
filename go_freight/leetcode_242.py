# simplest solution
def isAnagram(s: str, t: str) -> bool:
    return sorted(s) == sorted(t)


# dict solution
def isAnagram2(s: str, t: str) -> bool:
    sDict, tDict = {}
    for c in s:
        if c in sDict:
            sDict[c] += 1
        else:
            sDict[c] = 1
    for c in t:
        if c in tDict:
            tDict[c] += 1
        else:
            tDict[c] = 1
    return sDict == tDict


if __name__ == "__main__":
    pass
