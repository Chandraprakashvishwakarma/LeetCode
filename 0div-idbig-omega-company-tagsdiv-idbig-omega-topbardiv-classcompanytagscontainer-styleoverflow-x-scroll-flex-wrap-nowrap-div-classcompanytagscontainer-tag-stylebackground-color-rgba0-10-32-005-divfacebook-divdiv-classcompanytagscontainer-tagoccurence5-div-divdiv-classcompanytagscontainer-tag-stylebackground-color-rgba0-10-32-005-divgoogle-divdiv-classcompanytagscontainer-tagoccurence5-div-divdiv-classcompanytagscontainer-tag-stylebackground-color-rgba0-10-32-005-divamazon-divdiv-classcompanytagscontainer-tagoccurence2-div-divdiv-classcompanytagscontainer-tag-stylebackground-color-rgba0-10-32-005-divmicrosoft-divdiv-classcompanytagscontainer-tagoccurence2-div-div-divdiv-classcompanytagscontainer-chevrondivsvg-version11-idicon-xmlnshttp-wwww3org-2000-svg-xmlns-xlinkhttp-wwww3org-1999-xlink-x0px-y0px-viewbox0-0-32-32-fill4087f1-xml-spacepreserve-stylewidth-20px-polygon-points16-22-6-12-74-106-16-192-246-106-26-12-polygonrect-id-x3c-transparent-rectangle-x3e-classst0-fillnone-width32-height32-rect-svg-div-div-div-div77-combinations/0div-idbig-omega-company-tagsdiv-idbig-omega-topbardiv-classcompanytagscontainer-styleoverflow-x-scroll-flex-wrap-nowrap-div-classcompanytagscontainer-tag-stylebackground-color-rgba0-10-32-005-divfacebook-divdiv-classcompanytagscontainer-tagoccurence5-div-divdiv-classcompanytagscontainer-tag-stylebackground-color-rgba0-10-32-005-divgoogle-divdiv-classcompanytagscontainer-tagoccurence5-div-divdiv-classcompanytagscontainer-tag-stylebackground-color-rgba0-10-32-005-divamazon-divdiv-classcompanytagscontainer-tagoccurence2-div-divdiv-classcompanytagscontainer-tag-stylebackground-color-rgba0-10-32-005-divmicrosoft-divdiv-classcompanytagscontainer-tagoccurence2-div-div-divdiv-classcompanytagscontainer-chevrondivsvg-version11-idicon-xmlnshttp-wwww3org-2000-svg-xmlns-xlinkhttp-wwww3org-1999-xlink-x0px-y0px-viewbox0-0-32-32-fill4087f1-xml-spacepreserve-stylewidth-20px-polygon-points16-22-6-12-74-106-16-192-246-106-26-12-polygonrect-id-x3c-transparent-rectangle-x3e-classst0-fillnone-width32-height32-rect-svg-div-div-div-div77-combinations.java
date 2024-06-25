// class Solution {
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> res = new ArrayList<>();
//         getCombinations(1,n,k,new ArrayList<Integer>(),res);
//         return res;
//     }
//     public void getCombinations(int j,int n,int k,List<Integer> temp,List<List<Integer>> res){
//         if(temp.size() == k) {
//             res.add(new ArrayList<>(temp));
//             return;
//         }
//         for(int i=j;j<=n;j++){
//             temp.add(j);
//             getCombinations(j+1,n,k,temp,res);
//             temp.remove(temp.size()-1);
//         }
//     }
// }

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0)
            ans.add(new ArrayList(temp));
        else if (n > 0) {
            temp.add(n);
            combine(n-1, k-1);
            temp.remove(temp.size() - 1);
            if (k < n) 
                combine(n-1, k);
        }
        return ans;
    }
}