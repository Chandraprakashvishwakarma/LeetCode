class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = 0;
        for(int i:nums) sum+=i;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--){
            if(sum - nums[i]>nums[i]) return sum;
            else sum -= nums[i];
            if(i<3) return -1; 
        }
        return -1;
    }
}