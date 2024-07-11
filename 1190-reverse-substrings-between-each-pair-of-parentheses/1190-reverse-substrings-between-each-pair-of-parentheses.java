class Solution {
    public String reverseParentheses(String s) {
        if(s.length()<2) return s;  
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(sb);
                sb = new StringBuilder();
            }
            else if(c == ')'){
                sb = sb.reverse();
                if(st.size()>0) sb = st.pop().append(sb);
                
            }
            else sb.append(c);
        }
        
        return sb.toString();
    }
}
