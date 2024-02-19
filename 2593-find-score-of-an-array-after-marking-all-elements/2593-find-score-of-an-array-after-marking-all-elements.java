class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int [][] ar = new int[n][2];
        for(int i=0;i<n;i++){
            ar[i][0] = nums[i];
            ar[i][1] = i;
        }
        Arrays.sort(ar,(x,y)->x[0]-y[0]);
        boolean [] vis = new boolean[n];
        long score = 0;
        for(int i=0;i<n;i++){
            int val = ar[i][0];
            int index = ar[i][1];
            
            if(!vis[index]){
                score+=nums[index];
                vis[index] = true;
                if(index+1<n) vis[index+1] = true;
                if(index-1>=0) vis[index-1] = true;
            }
        }
        return score;
    }
}