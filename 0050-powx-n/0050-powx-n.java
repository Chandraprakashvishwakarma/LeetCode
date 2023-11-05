/*
Q. no. 15: Modular Exponentiation

Problem : Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

//type casting is must for test case n = -2147483648

*/

class Solution {
    public double myPow(double x, int n) {
        
        long nn = n;
        if(nn<0) nn=-nn;
        double ans = pow(x,nn);
        return n<0? (double)1.0/(double)ans:ans;
    }
    public static double pow(double x, long nn){
        if(nn==0) return (double)1.0;
        if(nn%2==1) return x*pow(x,nn-1);
        else return pow(x*x,nn/2);
    }
}
/*
Codding Ninjas:

Problem : You are given a three integers 'X', 'N', and 'M'. Your task is to find ('X' ^ 'N') %
'M'. A ^ B is defined as A raised to power B and A % C is the remainder when A is divided by C.


import java.util.* ;
import java.io.*; 
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int modularExponentiation(long x, long n, long m) {
        long ans = 1;
        long pow = n;
        while(pow>0){
            if(pow%2==0){
                x = ((x)*(x))%m;
                pow = pow/2;
            }else{
                ans = (ans*(x))%m;
                pow = pow-1;
            }
        }
        return (int)ans;
    }
}
*/