def min_cost_to_repair_edges(n, edges, edges_to_repair):
    
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