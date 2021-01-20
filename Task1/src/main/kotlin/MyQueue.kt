import java.util.*

class MyQueue() {

    /** Initialize your data structure here. */
    private val stack1: Stack<Int> = Stack()
    private val stack2: Stack<Int> = Stack()
    var front = 0

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        if (stack1.empty()) {
            front = x
        }
        stack1.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop())
            }
        }
        return if (stack2.empty()) -1 else stack2.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        if (!stack2.empty()) {
            return stack2.peek()
        }
        return if (!stack1.empty()) front else -1
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return stack1.empty() && stack2.empty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
