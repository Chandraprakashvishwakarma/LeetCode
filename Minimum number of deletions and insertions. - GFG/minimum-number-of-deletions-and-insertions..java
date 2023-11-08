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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java
class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    int lcs = longestCommonSubsequence(str1, str2);
        // System.out.println(lcs);
        return (str1.length()+str2.length())-2*lcs;
	} 
	
	public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        // int [][] dp = new int[n1+1][n2+1];
        int [] prev = new int[n2+1];
        int [] cur = new int[n2+1];
        // for(int []row:dp) Arrays.fill(row,-1);
        // return LCS(s1,s2,n1,n2,dp);
        
        //Tabulation
        for(int j=0;j<n2;j++) prev[j]=0;
            
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                int lcs = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){  //match condition
                    lcs = 1 + prev[j-1];
                }
                else { //not match
                    lcs = 0 + Math.max(cur[j-1],prev[j]);
                }
                cur[j] = lcs;
            }
            prev = cur.clone();
        }
        
        return prev[n2];
    }
}