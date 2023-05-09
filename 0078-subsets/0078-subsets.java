class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        helper(arr,arr.length,res,new ArrayList<Integer>(),0);
        return res;
    }
    void helper(int [] arr,int n,List<List<Integer>> res,List<Integer> temp,int index)      {
        if(index == n){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        helper(arr,n,res,temp,index+1);
        temp.add(arr[index]);
        helper(arr,n,res,temp,index+1);
        temp.remove(temp.size()-1);
    }
}