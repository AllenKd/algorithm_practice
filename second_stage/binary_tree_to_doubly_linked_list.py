class Node:
    def __init__(self, data):
        self.data = data
        self.left = self.right = None


class BinaryTree:
    root, head = None, None

    def b_to_dll(self, root):
        if not root:
            return

        self.b_to_dll(root.left)

        if not self.head:
            self.head = root
        else:
            root.left = self.head
            self.head.right = root
            self.head = root

        self.b_to_dll(root.right)

    def print_list(self, head):
        return self.print_list(head.left) + [head.data] if head.left else [head.data]


# description: https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
if __name__ == '__main__':
    tree = BinaryTree()
    tree.root = Node(5)
    tree.root.left = Node(3)
    tree.root.right = Node(6)
    tree.root.left.left = Node(1)
    tree.root.left.right = Node(4)
    tree.root.right.right = Node(8)
    tree.root.left.left.left = Node(0)
    tree.root.left.left.right = Node(2)
    tree.root.right.right.left = Node(7)
    tree.root.right.right.right = Node(9)

    tree.b_to_dll(tree.root)
    print(tree.print_list(tree.head))
