def countPairs(numbers, k):
    # n = len(numbers)
    numbers_set = set(numbers)
    pairs = set()
    for a in numbers_set:
        b = a + k
        if b in numbers_set:
            pairs.add((a, b))
    return len(pairs)


if __name__ == "__main__":
    print(countPairs([1, 1, 1, 2], 1))
    print(countPairs([1, 2], 0))
    print(countPairs([1, 2, 3, 4, 4, 4, 4, 0, 0], 2))
