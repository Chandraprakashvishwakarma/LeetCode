class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();
        int i=0,n=num.length();
        
        if(k == n) return "0";
        
        while(i<n){
            while(k>0 && !st.isEmpty() && num.charAt(i)<st.peek()){
                st.pop();
                k--;
            }
            if(st.isEmpty() && num.charAt(i) == '0') i++;
            else st.push(num.charAt(i++)); 
        }
        
        while(k>0 && !st.isEmpty()) {st.pop();k--;}
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.length()==0?"0":sb.reverse().toString();
    }
}

