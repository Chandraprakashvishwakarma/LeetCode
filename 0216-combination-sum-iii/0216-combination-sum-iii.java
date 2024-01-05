class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1,k,n,res,new ArrayList<Integer>());
        return res;
    }
    public void helper(int i,int k,int n,List<List<Integer>> res,List<Integer> temp){
        if(n == 0 && k==0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(n<0 || k<0) return;
        
        for(int j=i;j<=9;j++){
            temp.add(j);
            helper(j+1,k-1,n-j,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}