/*
Q. no. 56: Print Permutations
*/class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean [] used = new boolean[n];
        helper(nums,res,used,n,new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int [] nums,List<List<Integer>> res,boolean [] used,int n,List<Integer> temp){
        if(temp.size() == n) res.add(new ArrayList<>(temp));
        
        for(int i=0;i<n;i++){
            if(used[i]) continue;
            used[i] = true;
            temp.add(nums[i]);
            helper(nums,res,used,n,temp);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}

/*
Codding Ninjas:

import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<String> findPermutations(String s) {
        List<String> res = new ArrayList<>();
        boolean used[] = new boolean[s.length()];
        helper(s,res,-1,"",used);
        return res;
    }
    public static void helper(String s,List<String> res,int index,String temp,boolean [] used){
        if(temp.length()==s.length()) {res.add(temp);return;}
        for(int i=0;i<s.length();i++){
            if(!used[i]){
            used[i] =true;
            temp+=(s.charAt(i));
            helper(s,res,i,temp,used);
            used[i]=false;
            temp=temp.substring(0,temp.length()-1);
            }
        }
    }
}
*/