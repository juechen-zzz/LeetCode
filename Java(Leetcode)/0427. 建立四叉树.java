/* 
给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。

你需要返回能表示矩阵的 四叉树 的根结点。

注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。

四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：

val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}

 */

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/



class Solution {
    public Node construct(int[][] grid) {
        //left, right, up, down
        return helper(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node helper(int[][] grid, int left, int right, int up, int down){
        Node root  = new Node();
        if(isSame(grid, left, right, up, down)){
            root.val = grid[up][left] == 1 ? true : false;
            root.isLeaf = true;
            return root;
        }

        root.isLeaf = false;
        root.topLeft     = helper(grid, left,(right + left) / 2,  up, (up + down) / 2);
        root.topRight    = helper(grid, (right + left) / 2 + 1 , right, up, (up + down) / 2);
        root.bottomLeft  = helper(grid, left, (right + left) / 2 , (up + down) / 2 + 1, down);
        root.bottomRight = helper(grid, (right + left) / 2 + 1, right, (up + down) / 2 + 1, down);
        
        return root;
    }

    private boolean isSame(int[][] grid, int left, int right, int up, int down){
        int pre = -1;
        for(int i = up; i <= down; i++)
            for(int j = left; j <= right; j++)
                if(pre != -1){
                    if(pre != grid[i][j])
                        return false;
                }else
                    pre = grid[i][j];


        return true;
    }
}