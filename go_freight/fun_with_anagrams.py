def funWithAnagrams(alist):
    def stringDict(s):
        sDict = {}
        for c in s:
            if c in sDict:
                sDict[c] += 1
            else:
                sDict[c] = 1
        return sDict

    res = []
    dicts = []
    for l in alist:
        d = stringDict(l)
        if d not in dicts:
            res.append(l)
            dicts.append(d)
    return sorted(res)


if __name__ == "__main__":
    print(funWithAnagrams(["code", "doce", "ecod", "framer", "frame"]))
