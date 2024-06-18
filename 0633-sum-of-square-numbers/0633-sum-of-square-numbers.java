class Solution {
    public boolean judgeSquareSum(int c) {
        // if(c == 0) return true;
        int n = (int)Math.sqrt(c);
        for(int i=n;i>=0;i--){
            int val = c - (int)Math.pow(i,2);
            double sqrt = (int) Math.sqrt(val);
            if(val == sqrt*sqrt) return true;
        }
        return false;
    }
}