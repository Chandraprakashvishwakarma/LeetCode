class Solution {
    public String removeKdigits(String num, int k) {
        if(k<1) return num;
        Stack<Character> st = new Stack<>();
        int i=0,n=num.length();
        String res = "";
        int j = 0;
        while(i<n){
            while(k>0 && !st.isEmpty() && num.charAt(i)<st.peek()){
                st.pop();
                k--;
            }
            while(st.isEmpty() && i<n && num.charAt(i) == '0') i++;
            if(i<n) st.push(num.charAt(i++));
        }
        
        while(k>0 && !st.isEmpty()) {st.pop();k--;}
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.length()==0?"0":sb.toString();
    }
}

