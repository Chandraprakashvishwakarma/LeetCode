class Solution {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length;
        while(i<j){
            int mid = i + (j-i)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) i++;
            else j--;
        }
        return -1;
    }
}