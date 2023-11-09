//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    int [][] dp = new int[n+1][n+1];
	   // for(int [] row:dp) Arrays.fill(row,-1);
	   // return helper(arr,0,-1,n,dp);
	   
	   //Tabular 
	    for(int i=n-1;i>=0;i--){
	        for(int pre_ind = i-1;pre_ind>=-1;pre_ind--){
	            int sum = dp[i+1][pre_ind+1];
        	    if(pre_ind == -1 || arr[i]>arr[pre_ind]){
        	        sum = Math.max(sum,arr[i]+dp[i+1][i+1]);
        	    }
        	    dp[i][pre_ind+1] = sum;
	        }
	    }
	    return dp[0][-1+1];
	}
	
	// Memoization
// 	public int helper(int [] arr, int i,int pre_ind,int n, int [][] dp){
// 	    if(i == n) return 0;
	    
// 	    if(dp[i][pre_ind+1]!=-1) return dp[i][pre_ind+1];
// 	    int sum = helper(arr,i+1,pre_ind,n,dp);
// 	    if(pre_ind == -1 || arr[i]>arr[pre_ind]){
// 	        sum = Math.max(sum,arr[i]+helper(arr,i+1,i,n,dp));
// 	    }
// 	    return dp[i][pre_ind+1] = sum;
// 	}
}