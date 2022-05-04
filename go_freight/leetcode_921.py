def minAddToMakeValid(s: str) -> int:
    # left = right = 0
    # for i in s:
    #     if right == 0 and i == ')':
    #         left += 1
    #     else:
    #         right += 1 if i == '(' else -1

    # return left + right

    l = r = 0
    for c in s:
        if c == ")" and r == 0:
            l += 1
        else:
            r += 1 if c == "(" else -1

    return l + r




if __name__ == "__main__":
    minAddToMakeValid("()))((")
