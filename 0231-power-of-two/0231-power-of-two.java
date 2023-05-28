class Solution {
    long i=1;
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        if(n==i) return true;
        if(i>n) return false;
        i*=2;
        return isPowerOfTwo(n);
    }
}