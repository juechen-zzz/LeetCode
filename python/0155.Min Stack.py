'''
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
'''


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.min = None
        self.stack = []

    def push(self, x: int) -> None:
        if not self.stack :
            self.stack.append(x)
            self.min = x
        elif x >= self.min:
            self.stack.append(x)
        elif x < self.min:
            self.stack.append(2*x - self.min)
            self.min = x

    def pop(self) -> None:
        if not self.stack:
            return None
        else:
            popped = self.stack.pop()
            if popped < self.min: # it means number getting removed is min
                self.min = 2 * self.min - popped
                return self.min
            else:
                return popped

    def top(self) -> int:
        if not self.stack:
            return None
        else:
            peeked = self.stack[-1]
            if peeked < self.min:
                return self.min
            else:
                return peeked

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()