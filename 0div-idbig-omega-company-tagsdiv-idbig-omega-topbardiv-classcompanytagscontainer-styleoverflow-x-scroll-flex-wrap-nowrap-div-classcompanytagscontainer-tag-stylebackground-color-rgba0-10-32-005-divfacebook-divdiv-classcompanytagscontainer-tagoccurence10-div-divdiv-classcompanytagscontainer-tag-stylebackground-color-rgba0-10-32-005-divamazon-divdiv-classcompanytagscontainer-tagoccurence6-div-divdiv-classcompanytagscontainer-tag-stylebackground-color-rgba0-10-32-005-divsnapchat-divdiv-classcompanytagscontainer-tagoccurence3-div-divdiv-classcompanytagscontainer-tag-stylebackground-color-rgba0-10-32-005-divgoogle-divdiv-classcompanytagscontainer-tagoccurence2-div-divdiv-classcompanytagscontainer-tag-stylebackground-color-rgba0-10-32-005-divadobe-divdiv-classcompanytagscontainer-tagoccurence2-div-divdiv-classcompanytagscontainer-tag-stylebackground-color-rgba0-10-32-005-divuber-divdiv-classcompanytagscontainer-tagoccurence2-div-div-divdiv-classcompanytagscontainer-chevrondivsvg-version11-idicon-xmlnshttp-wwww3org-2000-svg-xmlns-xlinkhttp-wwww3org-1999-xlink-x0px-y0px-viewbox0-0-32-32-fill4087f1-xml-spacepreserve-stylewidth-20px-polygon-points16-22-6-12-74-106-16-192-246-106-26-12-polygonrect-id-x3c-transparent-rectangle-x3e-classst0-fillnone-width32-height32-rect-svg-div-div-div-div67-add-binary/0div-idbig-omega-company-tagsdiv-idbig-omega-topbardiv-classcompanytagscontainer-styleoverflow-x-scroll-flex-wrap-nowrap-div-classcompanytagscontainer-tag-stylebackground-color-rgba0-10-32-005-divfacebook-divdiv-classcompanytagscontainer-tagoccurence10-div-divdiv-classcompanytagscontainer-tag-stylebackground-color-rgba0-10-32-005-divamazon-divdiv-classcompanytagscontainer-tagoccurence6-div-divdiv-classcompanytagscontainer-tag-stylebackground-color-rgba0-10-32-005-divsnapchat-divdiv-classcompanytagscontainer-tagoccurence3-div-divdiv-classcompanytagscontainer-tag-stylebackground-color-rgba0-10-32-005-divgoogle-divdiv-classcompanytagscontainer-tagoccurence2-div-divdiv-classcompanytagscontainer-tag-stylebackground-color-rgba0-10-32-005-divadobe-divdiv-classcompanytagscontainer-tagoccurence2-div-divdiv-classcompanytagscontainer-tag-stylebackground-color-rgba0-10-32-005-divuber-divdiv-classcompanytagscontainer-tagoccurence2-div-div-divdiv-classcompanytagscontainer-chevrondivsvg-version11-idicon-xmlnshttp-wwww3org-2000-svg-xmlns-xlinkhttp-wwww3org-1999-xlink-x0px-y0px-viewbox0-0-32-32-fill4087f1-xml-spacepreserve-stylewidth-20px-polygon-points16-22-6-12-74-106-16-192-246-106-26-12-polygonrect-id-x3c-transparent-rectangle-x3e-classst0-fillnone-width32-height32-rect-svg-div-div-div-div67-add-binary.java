class Solution {
    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(m>=0 || n>=0 || carry>=1){
            int sum = 0;
            if(m>=0) {sum+=(a.charAt(m)-'0');m--;}
            if(n>=0) {sum+=(b.charAt(n)-'0');n--;}
            if(carry>=1) sum+=carry;
            
            sb.append((char)(sum%2 + '0'));
            carry = sum/2;
        }
        return sb.reverse().toString();
    }
}