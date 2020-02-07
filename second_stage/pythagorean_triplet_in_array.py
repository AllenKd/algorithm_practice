def pythagorean_triplet(arr):
    arr = sorted([i ** 2 for i in arr])

    for i in range(len(arr)-1, 1, -1):
        j = 0
        k = i - 1

        while j < k:
            if arr[j] + arr[k] == arr[i]:
                return True
            elif arr[j] + arr[k] < arr[i]:
                j += 1
            else:
                k -= 1
    return False


if __name__ == '__main__':
    print(pythagorean_triplet([3, 1, 4, 6, 5]))
