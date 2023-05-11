class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int target) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        helper(a,res,new ArrayList<Integer>(),target,0);
        return res;
    }
    public void helper(int [] a,List<List<Integer>> res,List<Integer> temp, int target,int start){
        if(target == 0) {
             res.add(new ArrayList<>(temp));
        }
        else if(target>0){
            for(int i=start;i<a.length;i++){
                if(i>start && a[i]==a[i-1]) continue;
                temp.add(a[i]);
                helper(a,res,temp,target-a[i],i+1);
                temp.remove(temp.size()-1);
            }
        }
        return;
    }
}