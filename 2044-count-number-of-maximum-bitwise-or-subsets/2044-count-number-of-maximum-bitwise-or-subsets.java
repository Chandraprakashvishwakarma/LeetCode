class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int MaxOr = 0;
        for(int i:nums) MaxOr = MaxOr|i;
        
        int [] ans = new int[1];
        
        findAllSubsetWithMaxOr(nums,0,ans,0,MaxOr);
        
        return ans[0];
    }
    
    private void findAllSubsetWithMaxOr(int [] nums,int i,int ans[],int OR,int MaxOr){
        if(i==nums.length && OR == MaxOr) {
            
            ans[0]++;
            return ;
        }
        if (i == nums.length) return ;
        
        findAllSubsetWithMaxOr(nums,i+1,ans,nums[i]|OR,MaxOr);
        findAllSubsetWithMaxOr(nums,i+1,ans,OR,MaxOr);
        
        return ;
    }
}