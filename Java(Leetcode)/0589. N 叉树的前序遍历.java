/* 
给定一个 N 叉树，返回其节点值的 前序遍历 。

N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。

进阶：

递归法很简单，你可以使用迭代法完成此题吗?

示例 1：
输入：root = [1,null,3,2,4,null,5,6]
输出：[1,3,5,6,2,4]

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
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) {return ans;}

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            Collections.reverse(node.children);
            for (Node adj : node.children) {
                stack.add(adj);
            }
        }
        return ans;
    }
}