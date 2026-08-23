class MyStack {
    Queue<Integer> queue;
    Queue<Integer> temp;

    public MyStack() {
        this.queue = new LinkedList<>();
        this.temp = new LinkedList<>();
    }
    
    public void push(int x) {
        this.temp.add(x);

        while(!queue.isEmpty()) {
            temp.add(queue.poll());
        }
        Queue<Integer> swap = queue;

        queue = temp;
        temp = swap;
    }
    
    public int pop() {
        return this.queue.poll();
    }
    
    public int top() {
        return this.queue.peek();
    }
    
    public boolean empty() {
        return this.queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */