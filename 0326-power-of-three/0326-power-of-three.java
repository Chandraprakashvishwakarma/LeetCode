/*using recursion 
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1) return true;
        if(n<1) return false;
        if(n%3!=0) return false;
        return isPowerOfThree(n/3);
    }
}
*/
//using log properties
/*
X = 3^N;
log10(X) = N*log10(3);
N = log10(X)/log10(3);
if N is integer then return true
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<1) return false;
        return (Math.log10(n)/Math.log10(3)%1 ==0);
    }
}