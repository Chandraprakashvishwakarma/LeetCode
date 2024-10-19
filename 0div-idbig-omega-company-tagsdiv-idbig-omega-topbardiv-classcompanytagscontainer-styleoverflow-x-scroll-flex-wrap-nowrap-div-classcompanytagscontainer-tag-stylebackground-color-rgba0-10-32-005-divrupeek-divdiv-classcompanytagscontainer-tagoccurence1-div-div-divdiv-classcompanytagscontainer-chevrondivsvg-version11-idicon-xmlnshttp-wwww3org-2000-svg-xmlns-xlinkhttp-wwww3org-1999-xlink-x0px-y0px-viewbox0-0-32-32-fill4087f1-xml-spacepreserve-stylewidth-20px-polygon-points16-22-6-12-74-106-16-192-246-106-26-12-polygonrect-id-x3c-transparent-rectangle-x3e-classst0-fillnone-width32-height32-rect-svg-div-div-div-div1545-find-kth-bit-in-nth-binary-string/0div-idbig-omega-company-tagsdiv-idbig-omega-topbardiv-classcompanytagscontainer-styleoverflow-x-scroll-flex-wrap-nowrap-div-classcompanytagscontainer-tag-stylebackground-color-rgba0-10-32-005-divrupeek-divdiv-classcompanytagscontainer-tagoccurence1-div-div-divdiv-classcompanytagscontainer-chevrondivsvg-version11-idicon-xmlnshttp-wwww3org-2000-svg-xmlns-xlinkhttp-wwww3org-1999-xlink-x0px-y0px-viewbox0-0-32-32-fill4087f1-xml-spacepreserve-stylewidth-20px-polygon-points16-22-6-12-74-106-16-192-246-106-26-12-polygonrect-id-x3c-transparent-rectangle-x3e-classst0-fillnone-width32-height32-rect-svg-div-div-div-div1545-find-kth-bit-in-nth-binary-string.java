class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for(int i=1;i<n;i++){
            StringBuilder invertedAndReversed = invertAndReverse(new StringBuilder(sb));
            sb.append('1');
            sb.append(invertedAndReversed);
            if(sb.length()>=k) break;
        }
        
        return sb.charAt(k-1);
    }
    
    private StringBuilder invertAndReverse(StringBuilder sb){
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) == '0'){
                sb.setCharAt(i,'1');
            }
            else {
                sb.setCharAt(i,'0');
            }
        }
        return sb.reverse();
    }
}