/* 
    丑数：只包含2 3 5位因子的数
 */

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {return 0;}
        if (index == 1) {return 1;}
        int[] ans = new int[index];
        
        ans[0] = 1;
        int u2 = 0, u3 = 0, u5 = 0;
        for (int i = 1; i < index; i++) {
            ans[i] = min(min(ans[u2] * 2, ans[u3] * 3), ans[u5] * 5);
            if(ans[u2] * 2 == ans[i])
                u2++;
            if(ans[u3] * 3 == ans[i])
                u3++;
            if(ans[u5] * 5 == ans[i])
                u5++;
        }
        
        return ans[index - 1];
    }
    
    private int min(int num1, int num2){
        return num1 < num2 ? num1 : num2;
    }
}