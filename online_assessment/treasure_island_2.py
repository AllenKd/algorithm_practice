from collections import deque


# extend version from treasure island
def treasure_island_2(m):
    if len(m) == 0 or len(m[0]) == 0:
        return -1  # impossible

    nrow, ncol = len(m), len(m)

    start_points = find_s(m)
    # matrix[sp[0]][sp[1]] = "D"
    min_steps = nrow + ncol
    for sp in start_points:
        matrix = [row[:] for row in m]
        q = deque([((sp[0], sp[1]), 0)])  # ((x, y), step)

        while q:
            (x, y), step = q.popleft()

            for dx, dy in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
                if 0 <= x + dx < nrow and 0 <= y + dy < ncol:
                    if matrix[x + dx][y + dy] == "X":
                        min_steps = min(min_steps, step + 1)
                    elif matrix[x + dx][y + dy] == "O":
                        # mark visited
                        matrix[x + dx][y + dy] = "D"
                        q.append(((x + dx, y + dy), step + 1))

    return -1 if min_steps == nrow + ncol else min_steps


def find_s(m):
    p = []
    for r in range(len(m)):
        for c in range(len(m[0])):
            if m[r][c] == 'S':
                p.append((r, c))
                m[r][c] = 'D'
    return p


# description: https://aonecode.com/amazon-online-assessment-questions#tt
if __name__ == '__main__':
    print(treasure_island_2([
        ['S', 'O', 'O', 'S', 'S'],
        ['D', 'O', 'D', 'O', 'D'],
        ['O', 'O', 'O', 'O', 'X'],
        ['X', 'D', 'D', 'O', 'O'],
        ['X', 'D', 'D', 'D', 'O']]))
