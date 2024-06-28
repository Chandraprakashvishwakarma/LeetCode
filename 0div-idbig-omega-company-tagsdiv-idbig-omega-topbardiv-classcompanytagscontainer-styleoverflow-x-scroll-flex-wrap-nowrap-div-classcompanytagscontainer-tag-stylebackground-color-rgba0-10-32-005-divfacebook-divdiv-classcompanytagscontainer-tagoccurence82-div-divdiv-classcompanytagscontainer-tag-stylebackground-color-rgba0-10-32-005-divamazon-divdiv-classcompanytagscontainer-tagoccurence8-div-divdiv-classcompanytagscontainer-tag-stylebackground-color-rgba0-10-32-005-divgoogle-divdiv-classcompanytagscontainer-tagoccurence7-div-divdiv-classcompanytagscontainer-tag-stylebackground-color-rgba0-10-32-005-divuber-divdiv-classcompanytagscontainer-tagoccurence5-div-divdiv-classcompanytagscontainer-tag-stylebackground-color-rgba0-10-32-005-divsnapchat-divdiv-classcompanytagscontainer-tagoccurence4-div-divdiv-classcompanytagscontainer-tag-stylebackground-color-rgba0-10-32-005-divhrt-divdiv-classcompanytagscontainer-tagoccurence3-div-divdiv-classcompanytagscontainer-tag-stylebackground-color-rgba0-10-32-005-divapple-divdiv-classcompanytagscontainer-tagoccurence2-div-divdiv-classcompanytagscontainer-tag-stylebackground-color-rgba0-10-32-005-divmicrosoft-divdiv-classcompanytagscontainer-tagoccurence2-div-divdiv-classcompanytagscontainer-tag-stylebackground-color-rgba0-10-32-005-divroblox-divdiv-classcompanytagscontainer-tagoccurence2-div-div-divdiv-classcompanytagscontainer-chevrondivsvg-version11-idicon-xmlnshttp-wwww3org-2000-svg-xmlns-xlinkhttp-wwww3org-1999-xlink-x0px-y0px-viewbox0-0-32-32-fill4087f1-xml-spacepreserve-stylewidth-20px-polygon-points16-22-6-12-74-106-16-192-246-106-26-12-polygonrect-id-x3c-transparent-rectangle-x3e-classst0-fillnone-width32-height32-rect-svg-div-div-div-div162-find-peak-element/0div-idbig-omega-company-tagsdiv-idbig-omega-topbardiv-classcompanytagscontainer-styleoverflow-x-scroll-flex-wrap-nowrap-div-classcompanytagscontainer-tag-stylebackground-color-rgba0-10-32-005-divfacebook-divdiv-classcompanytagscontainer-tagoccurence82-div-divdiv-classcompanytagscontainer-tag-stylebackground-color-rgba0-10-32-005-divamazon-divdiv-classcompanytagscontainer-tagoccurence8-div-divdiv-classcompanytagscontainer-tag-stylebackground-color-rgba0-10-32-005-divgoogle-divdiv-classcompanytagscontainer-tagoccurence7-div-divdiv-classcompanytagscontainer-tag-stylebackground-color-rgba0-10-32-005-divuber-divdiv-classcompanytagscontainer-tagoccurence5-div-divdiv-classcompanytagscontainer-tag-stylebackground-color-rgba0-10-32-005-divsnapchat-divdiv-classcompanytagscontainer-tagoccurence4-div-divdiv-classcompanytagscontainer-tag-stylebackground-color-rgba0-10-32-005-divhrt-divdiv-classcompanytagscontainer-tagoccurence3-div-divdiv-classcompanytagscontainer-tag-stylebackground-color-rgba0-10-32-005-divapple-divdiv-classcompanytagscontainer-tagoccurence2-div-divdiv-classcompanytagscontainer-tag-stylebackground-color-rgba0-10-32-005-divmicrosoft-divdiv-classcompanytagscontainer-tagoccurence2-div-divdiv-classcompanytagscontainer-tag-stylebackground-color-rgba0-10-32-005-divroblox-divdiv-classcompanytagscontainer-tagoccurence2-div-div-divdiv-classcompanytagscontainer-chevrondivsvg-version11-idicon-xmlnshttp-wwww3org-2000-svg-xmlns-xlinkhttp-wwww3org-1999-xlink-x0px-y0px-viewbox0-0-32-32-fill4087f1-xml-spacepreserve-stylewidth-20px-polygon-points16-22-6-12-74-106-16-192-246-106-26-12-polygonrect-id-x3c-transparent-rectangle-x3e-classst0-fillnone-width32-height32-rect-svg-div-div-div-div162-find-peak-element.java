class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        if(nums[1]<nums[0]) return 0;
        if(nums[n-2]<nums[n-1]) return n-1;
        int l = 1,h = n - 2;
        while(l<h){
            int mid = (h+l)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]>nums[mid-1]) l = mid+1;
            else h = mid-1;
        }
        return l;
    }
}