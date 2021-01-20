import java.util.*

class MyStack {

    /** Initialize your data structure here. */
    private val queue1: Queue<Int> = LinkedList()

    /** Push element x onto stack. */
    fun push(x: Int) {
        queue1.add(x)
        var sz = queue1.size
        while (sz > 1) {
            queue1.add(queue1.remove())
            --sz
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int = if (!queue1.isEmpty()) queue1.remove() else -1

    /** Get the top element. */
    fun top(): Int = if (!queue1.isEmpty()) queue1.peek() else -1

    /** Returns whether the stack is empty. */
    fun empty(): Boolean = queue1.isEmpty()

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
