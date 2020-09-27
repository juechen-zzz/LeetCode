"""
Implement the following operations of a stack using queues.
"""

class MyStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q = []
        

    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        self.q.insert(0, x)
        

    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        return self.q.pop(0)
        

    def top(self) -> int:
        """
        Get the top element.
        """
        return self.q[0]
        

    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return not bool(self.q)


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()


