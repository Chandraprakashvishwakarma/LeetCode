class MinStack {
    Stack<Integer> st;
    List<Integer> list;
    public MinStack() {
        st = new Stack<Integer>();
        list = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        if(list.size()==0 || val>list.get(0)) list.add(val);
        else list.add(0,val);
    }
    
    public void pop() {
        int val = st.peek();
        if(val == list.get(0)) list.remove(0);
        else list.remove(list.size()-1);
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return list.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */