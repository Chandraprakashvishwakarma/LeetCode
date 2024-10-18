class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int MaxOr = 0;
        for(int i:nums) MaxOr = MaxOr|i;
        
        int [] ans = new int[1];
        
        findAllSubsetWithMaxOr(nums,0,ans,0,MaxOr);
        
        return ans[0];
    }
    
    private void findAllSubsetWithMaxOr(int [] nums,int i,int ans[],int OR,int MaxOr){
        if(OR == MaxOr) ans[0]++;
        
        for(int j=i;j<nums.length;j++) 
            findAllSubsetWithMaxOr(nums,j+1,ans,nums[j]|OR,MaxOr);
    }
}