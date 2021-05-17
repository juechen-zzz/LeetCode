/* 
在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。

我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。

只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。

示例 1：
输入：root = [1,2,3,4], x = 4, y = 3
输出：false

示例 2：
输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
输出：true

示例 3：
输入：root = [1,2,3,null,4], x = 2, y = 3
输出：false
 */

// DFS
class Solution {
    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound = false;

    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {return;}

        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        }
        else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }

        if (xFound && yFound) {return;}
        dfs(node.left, depth + 1, node);

        if (xFound && yFound) {return;}
        dfs(node.right, depth + 1, node);
    }
}

// BFS
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            int n = queue.size();
            flag = false;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    // 判断 node.left 是否符合条件
                    // 如果符合：
                    //      （1）且同深度存在另一个符合条件的结点，返回true
                    //      （2）否则标记flag
                    if (node.left.val == x || node.left.val == y) {
                        if (flag) {return true;}
                        else {flag = true;}
                    }
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    // 判断 node.right 是否符合条件
                    // 如果符合：
                    //      （1）且node.left也符合条件，表示两个结点为兄弟结点，返回false
                    //      （2）且同深度存在另一个符合条件的结点（不是兄弟结点），返回true
                    //      （3）否则标记flag
                    if (node.right.val == x || node.right.val == y) {
                        if(node.left != null && (node.left.val == x || node.left.val == y)) {return false;}
                        else if (flag) {return true;}
                        else {flag = true;}
                    }
                    queue.offer(node.right);
                }
            }
        }

        return false;
    }
}