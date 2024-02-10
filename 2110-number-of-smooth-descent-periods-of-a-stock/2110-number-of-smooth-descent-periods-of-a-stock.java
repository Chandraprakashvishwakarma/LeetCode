class Solution {
    public long getDescentPeriods(int[] a) {
        long ans = 0;
        int dp[] = new int[a.length+1];
        for(int i=0;i<a.length;i++){
            if(dp[i]!=0) ans+=dp[i];
            else ans+=fn(a,i,-1,new ArrayList<Integer>(),dp);
        }
        return ans;
    }
    
    // dp =[0 0 0 0]
    
    public int fn(int [] a,int i,int pre,List<Integer> list,int [] dp){
        if(i == a.length) return 0;
        if(dp[i]!=0) return dp[i];
        if(list.size()==0 || pre-a[i] == 1) {
            list.add(a[i]);
            return dp[i] = 1+fn(a,i+1,a[i],list,dp);
        }
        return 0;
    }
}