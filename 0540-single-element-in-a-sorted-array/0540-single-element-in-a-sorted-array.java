class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0,high=nums.length-2,mid=0;
        while(low<=high){
            mid=(low+high)>>1;
            if(nums[mid]==nums[mid^1]) low=mid+1;
            else high=mid-1;
        }
        return nums[low];
    }
}