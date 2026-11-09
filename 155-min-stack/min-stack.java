class Node{
    int value;
    int minValue;
    Node next;
    Node(int value, int minValue, Node next){
        this.value = value;
        this.minValue = minValue;
        this.next = next;
    }
}

class MinStack {
    private Node head;
    
    public MinStack() {
    }
    
    public void push(int value) {
        if(head == null) head = new Node(value, value, null);
        else head = new Node(value, Math.min(value, head.minValue), head);  
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.minValue;
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