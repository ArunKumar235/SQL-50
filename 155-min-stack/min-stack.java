class Node{
    int value;
    int minValue;
    Node(int value, int minValue){
        this.value = value;
        this.minValue = minValue;
    }
}

class MinStack {
    Stack<Node> st;
    public MinStack() {
        this.st = new Stack<>();
    }
    
    public void push(int value) {
        int minValue = value;
        if(!st.isEmpty()){
            minValue = Math.min(minValue, st.peek().minValue);
        }
        st.push(new Node(value, minValue));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().value;
    }
    
    public int getMin() {
        return st.peek().minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */