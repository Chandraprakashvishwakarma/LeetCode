class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        int pre=1,suf=1;
        for(int i=0;i<n;i++){
            if(suf == 0) suf=1;
            if(pre == 0) pre=1;
            
            suf = suf * nums[i];
            pre = pre * nums[n-1-i];
            
            res = Math.max(res,Math.max(suf,pre));
        }
        return res;
    }
}