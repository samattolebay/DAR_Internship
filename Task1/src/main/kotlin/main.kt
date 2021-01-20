fun main(args: Array<String>) {
    val x = 17

    val myQueue = MyQueue()
    myQueue.push(x)     // Pushing 17
    myQueue.push(x + 32)    // Pushing 49
    myQueue.push(x - 2)     // Pushing 15
    myQueue.push(x + 131)   // Pushing 148
    myQueue.push(x * 3)     // Pushing 51
    println(myQueue.peek())     // Returns 17
    println(myQueue.pop())      // Returns 17
    println(myQueue.empty())    // Returns false

    println(myQueue.peek())     // Returns 49
    println(myQueue.pop())      // Returns 49
    println(myQueue.empty())    // Returns false


    val myStack = MyStack()
    myStack.push(x)     // Pushing 17
    myStack.push(x + 32)    // Pushing 49
    myStack.push(x - 2)     // Pushing 15
    myStack.push(x + 131)   // Pushing 148
    myStack.push(x * 3)     // Pushing 51
    println(myStack.top())     // Returns 51
    println(myStack.pop())      // Returns 51
    println(myStack.empty())    // Returns false

    println(myStack.top())     // Returns 148
    println(myStack.pop())      // Returns 148
    println(myStack.empty())    // Returns false
}