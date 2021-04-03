/* 
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

 */

class MedianFinder {
    private int count;
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap; 

    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        count++;
        maxheap.add(num);
        minheap.add(maxheap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if (count % 2 != 0) {
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if (count % 2 == 0) {
            return (double)(maxheap.peek() + minheap.peek()) / 2;
        }
        else {
            return (double)maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */