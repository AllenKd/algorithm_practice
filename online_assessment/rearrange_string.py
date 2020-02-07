def rearrange_string(s, k):
    s = list(s)
    s.sort(key=lambda e: s.count(e))
    distinct = set(s)
    if k > distinct:
        return ""

    if max([s.count(c) for c in distinct]) - min([s.count(c) for c in distinct]) >= 2:
        return ""

    c_dict = {}
    for c in distinct:
        pass
        # c_dict[c] = [c]s.count(c)
