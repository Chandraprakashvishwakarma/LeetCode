/*
Q. no. 183 : Word Break
*/
class Solution {
    public boolean wordBreak(String target, List<String> arr) {
        int n = target.length();
        Set<String> set = new HashSet<>();
        for(String s:arr) set.add(s);
        boolean dp [] = new boolean [n+1];
        
        //base case
        dp[n] = true;
        
        
        //change in parameter
        for(int i=n;i>=0;i--){
            
            //copy the recurrence
            String temp = "";
            for(int j=i;j<n;j++){
                temp+=target.charAt(j);
                if(set.contains(temp) && dp[j+1]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
        // return helper(0,target,set,dp);
    }
    
//     public boolean helper(int i,String s,Set<String> set,boolean []  dp){
//         if(i==s.length()) return true;
        
//         if(dp[i]) return dp[i];
        
//         String temp = "";
//         for(int j=i;j<s.length();j++){
//             temp+=s.charAt(j);
//             if(set.contains(temp) && helper(j+1,s,set,dp)) return dp[i] = true;
//         }
//         return dp[i] = false;
//     }
}

/*

Codding Ninjas:

import java.util.* ;

import java.io.*; 
public class Solution {
    public static Boolean wordBreak(String[] arr, int x, String target) {
        // Write your code here.
        int n = target.length();
        Set<String> set = new HashSet<>();

        for(String s:arr) set.add(s);
        
        boolean dp [] = new boolean [n+1];
        dp[n] = true;

        for(int i=n-1;i>=0;i--){
            String temp="";
            for(int j=i;j<n;j++){
                temp+=target.charAt(j);
                if(set.contains(temp) && dp[j+1]) dp[i] = true;
            }
            // return dp[i] = false; 
        }
        // Arrays.fill(dp,false);
        // return helper(0,target.length(),target,set,dp);
        return dp[0];
    }

    //recursion + Memoization 
    // public static boolean helper(int i,int n,String s,Set<String> set,boolean [] dp ){
    //     if(i == n) return true;

    //     if(dp[i] == true) return dp[i];
    //     String temp="";
    //     for(int j =i;j<n;j++){
    //         temp+=s.charAt(j);
    //         if(set.contains(temp) && helper(j+1, n, s,set,dp)) return dp[i] = true;
    //     }
    //     return dp[i] = false;    
    // }
}

*/