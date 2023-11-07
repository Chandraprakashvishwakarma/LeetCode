class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int pro = nums[i];
            res = Math.max(res,pro);
            for(int j=i+1;j<nums.length;j++){
                pro = pro* nums[j];
                res = Math.max(res,pro);
            }
        }
        return res;
    }
}