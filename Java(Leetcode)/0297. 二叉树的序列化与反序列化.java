/* 
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

示例 1：
输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return mySerialize(root, "");
    }

    public String mySerialize(TreeNode root, String s) {
        if (root == null) {
            s += "None,";
        }
        else {
            s += s.valueOf(root.val) + ",";
            s = mySerialize(root.left, s);
            s = mySerialize(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<String> datalist = new LinkedList<String>(Arrays.asList(strs));
        return myDeserialize(datalist);
    }

    public TreeNode myDeserialize(List<String> datalist) {
        if (datalist.get(0).equals("None")) {
            datalist.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(datalist.get(0)));
        datalist.remove(0);
        root.left = myDeserialize(datalist);
        root.right = myDeserialize(datalist);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));