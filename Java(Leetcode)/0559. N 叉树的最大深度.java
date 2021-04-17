/* 
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。

示例 1：

输入：root = [1,null,3,2,4,null,5,6]
输出：3

 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        Queue<Pair<Node, Integer>> stack = new LinkedList<>();
        if (root != null) {stack.add(new Pair(root, 1));}

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> cur = stack.poll();
            root = cur.getKey();
            int curDepth = cur.getValue();
            if (root != null) {
                depth = Math.max(depth, curDepth);
                for (Node c : root.children) {
                    stack.add(new Pair(c, curDepth + 1));
                }
            }
        }

        return depth;
    }
}