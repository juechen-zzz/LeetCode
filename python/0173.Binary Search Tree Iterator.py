"""
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.



Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false


Note:

next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.inorder = []
        self.p = 0

        node = root
        while node:
            if node.left:
                pre = node.left
                while pre and pre.right and pre.right != node:
                    pre = pre.right
                if not pre.right:
                    pre.right = node
                    node = node.left
                else:
                    pre.right = None
                    self.inorder.append(node.val)
                    node = node.right


            else:
                self.inorder.append(node.val)
                node = node.right
        # print(self.inorder)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        self.p += 1
        return self.inorder[self.p - 1]

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.p < len(self.inorder)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()