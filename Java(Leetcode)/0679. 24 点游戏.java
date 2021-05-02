/* 
你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。

示例 1:

输入: [4, 1, 8, 7]
输出: True
解释: (8-4) * (7-1) = 24
示例 2:

输入: [1, 2, 1, 2]
输出: False

 */

class Solution {
    private static final int TARGET = 24;
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> ans = new ArrayList<>();
        for (int n : cards) {ans.add((double) n);}
        return myMethod(ans);
    }

    private static boolean myMethod(List<Double> list) {
        if (list.size() == 0) {return false;}
        if (list.size() == 1) {return Math.abs(list.get(0) - TARGET) < EPSILON;}

        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == 0) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == 1) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == 2) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == 3) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (myMethod(list2)) {return true;}
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}