class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long ans = 0;
        int j=0;
        for(int i=n-1;i>=0;i--){
            if(happiness[i]-j>=0) ans = ans + happiness[i] - j;
            j++;
            if(j == k) break;
        }
        return ans;
    }
}