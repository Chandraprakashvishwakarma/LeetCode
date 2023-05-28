/*
//using bit manipulation 
// binary for 0x55555555 is 01010101010101010101010101
// 4 - 100  16 - 10000     64-1000000    256-100000000 ..........
//if(n is pow of 2 and 100 & 010 == 0) means it is power of 4 
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}
*/
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1) return true;
        if(n<1) return false;
        if(n%4!=0) return false;
        return isPowerOfFour(n/4);
    }
}