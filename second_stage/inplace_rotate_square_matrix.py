def rotate_matrix(m):
    n = len(m) // 2
    for x in range(n):
        for y in range(x, len(m) - x - 1):
            temp = m[x][y]
            m[x][y] = m[y][len(m) - x - 1]
            m[y][len(m) - x - 1] = m[len(m) - 1 - x][len(m) - 1 - y]
            m[len(m) - x - 1][len(m) - y - 1] = m[len(m) - y - 1][x]
            m[len(m) - y - 1][x] = temp
    return m


def display_matrix(m):
    for i in range(len(m)):
        for j in range(len(m)):
            print(m[i][j], end=' ')
        print()


# description: https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
if __name__ == '__main__':
    m = [[1, 2, 3, 4],
         [5, 6, 7, 8],
         [9, 10, 11, 12],
         [13, 14, 15, 16]]
    display_matrix(rotate_matrix(m))
