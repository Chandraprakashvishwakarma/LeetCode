/*
Q. no. 17: Unique Paths
*/
class Solution {
    //Using formula 
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];
        return findUnique(0,0,m-1,n-1,dp);
    }
    public int findUnique(int i,int j,int m,int n,int [][]dp){
        if(i==m && j == n) return 1;
        if(i>m || j>n) return 0;
        
        if(dp[i][j]!=0) return dp[i][j];
        
        return dp[i][j] = findUnique(i+1,j,m,n,dp)+findUnique(i,j+1,m,n,dp);
    }
    
}

/*
Codding Ninjas:

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		//Interative solution with O(MxN) space 
		int [][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int up=0;
                int left=0;
                if(i==0 && j==0) dp[i][j]=1;
                else {
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left =dp[i][j-1];
                    dp[i][j] = left+up;
                }
            }
        }
        return dp[m-1][n-1]; 
		//Recursive solution with O(MxN) space 
		// int [][] dp = new int [m+1][n+1];
		// return helper(m-1,n-1,dp);
	}
	public static int helper(int m, int n,int[][]dp){
		if(m==0 && n==0) return 1;
		if(m<0 || n<0) return 0;
		if(dp[m][n]!=0) return dp[m][n];
		return dp[m][n]= helper(m-1,n,dp)+helper(m,n-1,dp);
	}
}

*/