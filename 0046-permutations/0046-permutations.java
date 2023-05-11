class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,new ArrayList<Integer>());
        return res;
    }
    public void helper(int [] a,List<List<Integer>> res,List<Integer> temp){
        if(temp.size()==a.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<a.length;i++){
            if(temp.contains(a[i])) continue;
            temp.add(a[i]);
            helper(a,res,temp);
            temp.remove(temp.size()-1);
        }
        return;
    }
}