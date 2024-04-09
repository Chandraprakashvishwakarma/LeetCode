class Solution {
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        getSubsets(a,0,res,new ArrayList<Integer>());
        return res;
    }
    
    private void getSubsets(int [] a, int idx, List<List<Integer>> res , List<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i=idx;i<a.length;i++){
            temp.add(a[i]);
            getSubsets(a,i+1,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}