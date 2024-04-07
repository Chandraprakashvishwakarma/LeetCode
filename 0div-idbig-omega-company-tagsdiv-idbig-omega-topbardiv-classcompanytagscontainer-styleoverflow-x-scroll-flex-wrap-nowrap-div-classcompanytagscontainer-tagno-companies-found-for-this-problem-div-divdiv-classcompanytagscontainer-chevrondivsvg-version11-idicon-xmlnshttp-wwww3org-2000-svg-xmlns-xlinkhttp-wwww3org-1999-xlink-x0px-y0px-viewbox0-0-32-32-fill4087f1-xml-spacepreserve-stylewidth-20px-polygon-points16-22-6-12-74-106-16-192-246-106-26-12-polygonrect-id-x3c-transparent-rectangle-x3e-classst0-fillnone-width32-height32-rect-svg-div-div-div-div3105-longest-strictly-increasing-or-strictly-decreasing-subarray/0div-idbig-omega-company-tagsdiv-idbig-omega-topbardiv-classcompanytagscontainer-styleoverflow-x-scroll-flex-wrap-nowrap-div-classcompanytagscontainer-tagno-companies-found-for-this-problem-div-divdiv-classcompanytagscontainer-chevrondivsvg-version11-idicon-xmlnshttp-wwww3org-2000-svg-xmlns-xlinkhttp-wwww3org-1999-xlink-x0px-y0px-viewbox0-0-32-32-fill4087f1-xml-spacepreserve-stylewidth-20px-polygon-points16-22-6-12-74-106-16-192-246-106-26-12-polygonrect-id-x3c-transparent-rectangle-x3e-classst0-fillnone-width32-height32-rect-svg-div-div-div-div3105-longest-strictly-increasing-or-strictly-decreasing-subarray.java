class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int i=0,n=nums.length;
        int max = 1;
        int c1=1,c2=1;
        while(i<n){
            if(i<n-1 && nums[i]<nums[i+1]){
                c2=1;c1++;
            }
            else if(i<n-1 && nums[i]>nums[i+1]){
                c1=1;c2++;
            }
            else {
                c1=1;c2=1;
            }
            i++;
            max = Math.max(max,Math.max(c1,c2));
        }
        return max;
    }
}