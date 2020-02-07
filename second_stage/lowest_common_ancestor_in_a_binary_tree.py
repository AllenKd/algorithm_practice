class Node:
    # Constructor to create a new binary node
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


def find_path(root, target):
    if not root:
        return False

    if root.key == target:
        return [root.key]

    left = find_path(root.left, target)
    right = find_path(root.right, target)
    if left:
        return [root.key] + left
    if right:
        return [root.key] + right
    return None


def find_lca(root, n1, n2):
    p1 = find_path(root, n1)
    p2 = find_path(root, n2)

    for i in range(min(len(p1), len(p2))):
        if p1[i] != p2[i]:
            return p1[i-1]

    return p1[min(len(p1), len(p2)) - 1]


# description: https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
if __name__ == '__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    print(find_lca(root, 4, 5))
    print(find_lca(root, 4, 6))
    print(find_lca(root, 3, 4))
    print(find_lca(root, 2, 4))
