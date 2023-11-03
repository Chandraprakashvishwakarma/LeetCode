class Solution {
    public void merge(int[] nums1, int i, int[] nums2, int j) {
        int n = i+j-1;i--;j--;
        while(i>=0 && j>=0){
            if(nums2[j]>nums1[i]) nums1[n--]=nums2[j--];
            else nums1[n--]=nums1[i--];
        }
        while(j>=0) nums1[n--]=nums2[j--];
    }
}