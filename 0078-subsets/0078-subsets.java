class Solution {
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        helper(a,res,temp,0);
        return res;
    }
    public void helper(int[] a,List<List<Integer>> res ,List<Integer> temp,int start){
        res.add(new ArrayList<Integer>(temp));
        for(int j=start;j<a.length;j++){
            temp.add(a[j]);
            helper(a,res,temp,j+1);
            temp.remove(temp.size()-1); 
        }
    }
}