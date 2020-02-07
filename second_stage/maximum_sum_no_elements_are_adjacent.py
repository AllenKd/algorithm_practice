def max_sum(arr):
    incl = excl = 0
    for i in arr:
        new_excl = max(excl, incl)
        incl = excl + i
        excl = new_excl
    return max(incl, excl)


# description: https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
if __name__ == '__main__':
    print(max_sum([5, 5, 10, 100, 10, 5]))