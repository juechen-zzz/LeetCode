/*
给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:
num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。

示例 1 :
输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
*/

// 1 回溯（超时）
class Solution {
    List<Integer> res = new ArrayList<>();

    public String removeKdigits(String num, int k) {
        char[] nums = num.toCharArray();
        backtrack(nums, k, 0);
        return Collections.min(res).toString();
    }

    void backtrack(char[] nums, int count, int start){
        if (count == 0) {
            res.add(string2int(nums));
            return;
        }
        for (int i = start; i < nums.length; i++){
            char tmp = nums[i];
            nums[i] = 'a';
            backtrack(nums, count - 1, i + 1);
            nums[i] = tmp;
        }
    }

    public int string2int(char[] n){
        int ans = 0;
        for (char c : n){
            if (Character.isDigit(c)){
                ans = ans * 10 + Integer.parseInt(String.valueOf(c));
            }
        }
        return ans;
    }
}

// 2 栈
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder ans = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char curNum = deque.pollFirst();
            if (leadingZero && curNum == '0') {continue;}
            leadingZero = false;
            ans.append(curNum);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}