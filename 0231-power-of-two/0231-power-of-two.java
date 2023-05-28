//using recursion 
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if(n<1) return false;
        if(n%2==1) return false;
        
        return isPowerOfTwo(n/2);
    }
}
/*
//O(1) solution without iteration or recursion
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        else return ((n&(n-1))==0);
    }
}
*/