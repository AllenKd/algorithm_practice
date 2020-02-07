def k_largest_element(arr, k):
    if k >= len(arr):
        return arr

    out = []
    for _ in range(k):
        out.append(arr.pop(arr.index(max(arr))))
    return out


if __name__ == '__main__':
    print(k_largest_element([1, 23, 12, 9, 30, 2, 50], 3))
