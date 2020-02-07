def min_cost(n, connections):
    if len(connections) < n - 1:
        return -1

    def get_min_edge(tree):
        nodes = set()
        for e in tree:
            nodes.add(e[0])
            nodes.add(e[1])

        min_edge = [None, None, None]
        for n in nodes:
            for c in cities[n]:
                if c not in nodes:
                    if min_edge[0] is None or min_edge[2] > cities[n][c]:
                        min_edge = [n, c, cities[n][c]]
        return min_edge

    connections.sort(key=lambda x: x[-1])
    cities = {}
    for c in connections:
        if c[0] not in cities:
            cities[c[0]] = {c[1]: c[2]}
        else:
            cities[c[0]][c[1]] = c[2]
        if c[1] not in cities:
            cities[c[1]] = {c[0]: c[2]}
        else:
            cities[c[1]][c[0]] = c[2]

    added_nodes = {connections[0][0], connections[0][1]}
    edges = [connections[0]]
    while True:
        min_edge = get_min_edge(edges)
        if min_edge[0] is not None:
            added_nodes.add(min_edge[0])
            added_nodes.add(min_edge[1])
            edges.append(min_edge)
        else:
            return -1

        if len(added_nodes) == n:
            sum = 0
            for e in edges:
                sum += e[2]
            return sum


# description: https://aonecode.com/amazon-online-assessment-oa2-min-cost-to-add-new-roads
if __name__ == '__main__':
    print(min_cost(3, [[1, 2, 5], [1, 3, 6], [2, 3, 1]]))
    print(min_cost(4, [[1, 2, 3], [3, 4, 4]]))
    min_cost(9, [[1, 4, 3], [2, 4, 1], [1, 0, 5], [0, 3, 3], [0, 5, 2], [3, 6, 5], [6, 4, 3], [5, 7, 1], [7, 8, 4], [4, 8, 5], [4, 5, 1], [8, 5, 4]])
