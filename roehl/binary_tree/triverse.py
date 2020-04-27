class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key


def inorder(root):
    if root:
        inorder(root.left)
        print(root.val)
        inorder(root.right)


def postorder(root):
    if root:
        postorder(root.left)
        postorder(root.right)
        print(root.val)


def preorder(root):
    if root:
        print(root.val)
        preorder(root.left)
        preorder(root.right)


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

    inorder(root)
    print()
    postorder(root)
    print()
    preorder(root)
    print()
    levelorder(root)
