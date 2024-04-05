/*
Q. no. 51: Return Subsets Sum to K ( Combination Sum )
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
        getAllCombinationSum(a,target,0,res,new ArrayList<>());
        return res;
    }
    private void getAllCombinationSum(int [] a, int target,int idx, List<List<Integer>> res , List<Integer> temp){
        if(target == 0){
            res.add(new ArrayList(temp));
            return;
        }
        if(target<0) return;
        
        for(int i=idx;i<a.length;i++){
            temp.add(a[i]);
            getAllCombinationSum(a,target-a[i],i,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}

/*
Codding Ninjas:

import java.util.*;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(arr,res,new ArrayList<>(),0,0,k);
        return res;
        }
        public static void helper(ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> res , ArrayList<Integer> temp,int index ,int sum ,int k){
            if(sum == k) res.add(new ArrayList<>(temp));
            for(int i=index;i<arr.size();i++){
                sum+=arr.get(i);
                temp.add(arr.get(i));
                helper(arr,res,temp,i+1,sum,k);
                sum-=arr.get(i);
                temp.remove(temp.size()-1);
            }
            return;
        }
}
*/