class Solution {
    public List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        helper(a,res,new ArrayList<Integer>(),target,0);
        return res;
    }
    public void helper(int [] a,List<List<Integer>> res,List<Integer> temp,int target,int start){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target>0){for(int i=start;i<a.length;i++){
            temp.add(a[i]);
            helper(a,res,temp,target-a[i],start);
            temp.remove(temp.size()-1);
            start++;
        }}
        return;
    }
}