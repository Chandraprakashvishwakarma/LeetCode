class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<2) return;
        int br = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                br=i;
                break;
            }
        }
        if(br == -1) {
            reverse(nums,0,n-1);
            return ;
        }
        
        for(int i=n-1;i>=br;i--){
            if(nums[i]>nums[br]){
                swap(nums,i,br);
                break;
            }
        }
        reverse(nums,br+1,n-1);
        return ;
    }
    
    public void reverse(int [] nums, int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;j--;
        }
    }
    
    public void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}