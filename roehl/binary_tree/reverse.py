class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key


def reverse(root):
    if root:
        root.left, root.right = root.right, root.left
        reverse(root.left)
        reverse(root.right)
    return root


def levelorder(root):
    if root:
        q = []
        q.append(root)

        while len(q):
            n = q.pop(0)
            print(n.val)
            if n.left:
                q.append(n.left)
            if n.right:
                q.append(n.right)


if __name__ == "__main__":
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)

    levelorder(reverse(root))
