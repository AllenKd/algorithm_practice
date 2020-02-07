def minimumHours(rows, columns, grid):
    # WRITE YOUR CODE HERE
    if not rows or not columns:
        return 0

    q = [[i, j] for i in range(rows) for j in range(columns) if grid[i][j] == 1]
    if len(q) == rows * columns:
        return 0

    directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    hour = 0

    while True:
        new = []

        for i, j in q:
            for d in directions:
                ni, nj = i + d[0], j + d[1]
                if 0 <= ni < rows and 0 <= nj < columns and grid[ni][nj] == 0:
                    grid[ni][nj] = 1
                    new.append([ni, nj])

        q = new
        if not q:
            break
        hour += 1

    return hour


if __name__ == '__main__':
    print(minimumHours(10, 1, [[1], [0], [0], [0], [0], [0], [0], [0], [0], [0]]))
