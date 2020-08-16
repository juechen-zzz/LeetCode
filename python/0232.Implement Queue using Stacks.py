"""
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
"""

class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q = []


    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.q.append(x)


    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        x = self.q.pop(0)
        return x


    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.q[0]


    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.q) == 0



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()