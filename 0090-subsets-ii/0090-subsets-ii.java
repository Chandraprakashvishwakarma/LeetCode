class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        helper(nums,res,new ArrayList<Integer>(),0);
        return res;
    }
    public void helper(int[] nums,List<List<Integer>> res, List<Integer> temp,int start){
        res.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            if(i!=start && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            helper(nums,res,temp,i+1);
            temp.remove(temp.size()-1);
        }
        return;
    }
}