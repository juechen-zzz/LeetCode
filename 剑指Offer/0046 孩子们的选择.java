/* 
0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

 */

//use ArrayList
import java.util.*;
public class Solution {
    public static int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 0) {return -1;}
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        
        int index = 0;
        while(list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
