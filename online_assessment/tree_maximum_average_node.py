class TreeNode:
    def __init__(self, value):
        self.val = value
        self.children = []


class Solution:
    def maxAverageSubtree(self, root):
        if not root or not root.children:
            return None

        self.res = [float('-inf'), 0]
        # self.res[0]: average; self.res[1]: number of nodes
        self.dfs(root)
        return self.res[1]

    def dfs(self, root):
        if not root.children:
            return [root.val, 1]

        temp_sum, temp_num = root.val, 1
        for child in root.children:
            child_sum, child_num = self.dfs(child)
            temp_sum += child_sum
            temp_num += child_num

        if temp_sum / temp_num > self.res[0]:
            self.res = [temp_sum / temp_num, root.val]

        return [temp_sum, temp_num]


# description: https://aonecode.com/amazon-subtree-with-maximum-average
if __name__ == '__main__':
    a = TreeNode(20)
    a.children = [TreeNode(12), TreeNode(18)]
    a.children[0].children = [TreeNode(11), TreeNode(2), TreeNode(3)]
    a.children[1].children = [TreeNode(15), TreeNode(8)]
    Solution().maxAverageSubtree(a)
