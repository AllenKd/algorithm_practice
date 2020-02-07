def critical_connection(server_num, connections):
    g = [[] for _ in range(server_num)]
    for u, v in connections:
        g[u].append(v)
        g[v].append(u)

    ctc_conn = []
    levels = [server_num] * server_num

    def dfs(node, level, parent):
        if levels[node] == server_num:
            levels[node] = level

            for neighbor in g[node]:
                if neighbor != parent:

                    expected_child_level = level + 1
                    actual_child_level = dfs(neighbor, expected_child_level, node)

                    if actual_child_level >= expected_child_level:
                        ctc_conn.append((node, neighbor))

                    levels[node] = min(levels[node], actual_child_level)
        return levels[node]

    dfs(0, 0, -1)

    return ctc_conn


if __name__ == '__main__':
    print(critical_connection(4, [[0, 1], [1, 2], [2, 0], [1, 3]]))
    print(critical_connection(9, [[1, 2], [1, 3], [2, 3], [3, 4], [3, 6], [4, 5], [6, 7], [6, 0], [7, 8], [8, 0]]))
