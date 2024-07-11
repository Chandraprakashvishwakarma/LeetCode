class Solution {
    public String reverseParentheses(String s) {
        if(s.length()<2) return s;  
        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ')') st.push(s.charAt(i));
            else {
                while(st.peek()!='('){
                    q.offer(st.pop());
                }
                if(st.peek() == '('){
                    st.pop();
                    while(!q.isEmpty()){
                        st.push(q.poll());
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}