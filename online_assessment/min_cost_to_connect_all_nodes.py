import heapq


def min_cost_to_connect_all_nodes(n, edges, new_edges):
    g = {n: {} for n in range(1, n + 1)}

    for u, v, cost in new_edges:
        g[u][v] = cost

    for u, v in edges:
        g[u][v] = 0

    start = 1
    visited = []
    q = []

    for dest, cost in g[start].items():
        heapq.heappush(q, (cost, dest, start))
    visited.append(start)

    total_cost = 0
    while len(visited) < n:
        cost, new_src, src = heapq.heappop(q)
        if new_src in visited:
            # skip connected node
            continue
        if [src, new_src, cost] in new_edges or [new_src, src, cost] in new_edges:
            total_cost += cost
        for dest, cost in g[new_src].items():
            heapq.heappush(q, (cost, dest, src))
        visited.append(new_src)
    return total_cost


# description: https://aonecode.com/amazon-online-assessment-questions#1m
if __name__ == '__main__':
    assert min_cost_to_connect_all_nodes(6, [[1, 4], [4, 5], [2, 3]], [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]) ==  7
    assert min_cost_to_connect_all_nodes(5, [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]], [[1, 2, 12], [3, 4, 30], [1, 5, 8]]) == 0
    assert min_cost_to_connect_all_nodes(6, [[1, 2], [2, 3], [4, 5], [3, 5], [1, 6], [2, 4]], [[1, 6, 410], [2, 4, 800]]) == 0
    assert min_cost_to_connect_all_nodes(6, [[1, 2], [2, 3], [4, 5], [5, 6], [1, 5], [2, 4], [3, 4]], [[1, 5, 110], [2, 4, 84], [3, 4, 79]]) == 0
