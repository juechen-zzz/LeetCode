/* 
给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。

第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。

返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。

 

示例 1：

输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
输出：[3,3,7]
解释：
1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
2) 1 XOR 2 = 3.
3) 5 XOR 2 = 7.
示例 2：

输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
输出：[15,-1,5]

 */

// 超时
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int cur = queries[i][0];
            int curMax = 0;
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= queries[i][1]) {
                    flag = false;
                    curMax = Math.max(curMax, nums[j] ^ cur);
                    // System.out.println(nums[j] + "..." + cur);
                }
                if (flag) {curMax = -1;}
            }
            ans[i] = curMax;
        }

        return ans;
    }
}

// 字典树
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        for (int val : nums) {
            trie.insert(val);
        }
        int numQ = queries.length;
        int[] ans = new int[numQ];
        for (int i = 0; i < numQ; ++i) {
            ans[i] = trie.getMaxXorWithLimit(queries[i][0], queries[i][1]);
        }
        return ans;
    }
}

class Trie {
    static final int L = 30;
    Trie[] children = new Trie[2];
    int min = Integer.MAX_VALUE;

    public void insert(int val) {
        Trie node = this;
        node.min = Math.min(node.min, val);
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new Trie();
            }
            node = node.children[bit];
            node.min = Math.min(node.min, val);
        }
    }

    public int getMaxXorWithLimit(int val, int limit) {
        Trie node = this;
        if (node.min > limit) {return -1;}
        int ans = 0;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node.children[bit ^ 1] != null && node.children[bit ^ 1].min <= limit) {
                ans |= 1 << i;
                bit ^= 1;
            }
            node = node.children[bit];
        }
        return ans;
    }
}