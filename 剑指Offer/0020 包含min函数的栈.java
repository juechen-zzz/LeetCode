/* 
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 */

import java.util.Stack;
import java.util.ArrayList;

public class Solution {

    ArrayList<Integer> list = new ArrayList<>();
    public void push(int node) {
        list.add(0, node);
    }
    
    public void pop() {
        list.get(0);
        list.remove(0);
    }
    
    public int top() {
        return list.get(0).intValue();
    }
    
    public int min() {
        int tmp = top();
        for (int i = 1; i < list.size(); i++) {
            if (tmp > list.get(i).intValue()) {
                tmp = list.get(i).intValue();
            }
        }
        return tmp;
    }
}