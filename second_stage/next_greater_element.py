def next_greater_element(arr):
    s = [arr[0]]

    for i in range(1, len(arr)):
        nxt = arr[i]

        if s:
            element = s.pop()

            while element < nxt:
                print(str(element) + '--' + str(nxt))
                if not s:
                    break
                element = s.pop()

            if element > nxt:
                s.append(element)
        s.append(nxt)

    while s:
        print(str(s.pop()) + '-- -1')


# description: https://www.geeksforgeeks.org/next-greater-element/
if __name__ == '__main__':
    arr = [11, 13, 21, 3]
    next_greater_element(arr)
    next_greater_element([4, 5, 2, 25])
    next_greater_element([13, 7, 6, 12])
