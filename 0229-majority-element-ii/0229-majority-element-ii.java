/*
Q. no. 16: Majority Element II
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int c1=0,c2=0,el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
        for(int i:nums){
            if(c1 == 0 && i!=el2){
                el1=i;
                c1=1;
            }
            else if(c2 == 0 && i!=el1){
                el2 = i;
                c2 =1;
            }
            else if(i == el1) c1++;
            else if(i == el2) c2++;
            else {
                c1--;c2--;
            }
        }
        c1=0;c2=0;
        for(int i:nums){
            if(i == el1) c1++;
            else if(i == el2) c2++;
        }
        if(c1>=nums.length/3 +1) res.add(el1);
        if(c2>=nums.length/3 +1) res.add(el2);
        return res;
    }
}

/*
Codding Ninjas:

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        int el1 = 0,el2 =0,c1=0,c2=0;
        for(int i:arr){
            if(c1==0 && i!=el2){
                el1=i;
                c1=1;
            }
            else if(c2==0 && i!=el1){
                el2=i;
                c2=1;
            }
            else if(i == el1) c1++;
            else if(i == el2) c2++;
            else {c1--;c2--;}
        }
        c1=0;c2=0;
        for(int i:arr){
            if(i == el1) c1++;
            else if(i==el2) c2++;
        }
        if(c1>arr.size()/3) res.add(el1);
        if(c2>arr.size()/3) res.add(el2);
        return res;
    }
}

*/