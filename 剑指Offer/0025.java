/* 
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
请对此链表进行深拷贝，并返回拷贝后的头结点。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
import java.util.HashMap;
public class Solution {
    private HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode myHead = new RandomListNode(-1);
        RandomListNode p = pHead;
        RandomListNode q = myHead;
        while(p != null){
            RandomListNode tempNode = new RandomListNode(p.label);
            q.next = tempNode;
            map.put(p, tempNode);
            p = p.next;
            q = q.next;
        }
        p = pHead;
        q = myHead.next;
        while(p != null){
            if(p.random != null)
                q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return myHead.next;
    }
}