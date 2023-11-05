/*
Q. no. 20: 4Sum (Find Four Elements That Sums To A Given Value)
*/

// -2 -1 0 0 1 2  target = 0
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k = j+1, l= n-1;
                while(k<l){
                    long val = nums[i];
                    val+=nums[j];
                    val+=nums[k];
                    val+=nums[l];
                    if(val == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);temp.add(nums[l]);
                        res.add(temp);
                        k++;l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                    else if(val<target) k++;
                    else l--;
                }
            }
        }
        return res;
    }
}

/*
Codding Ninjas:
Problem: You are given an array/list 'ARR' of 'N' integers and an integer value 'TARGET'.
You need to check whether there exist four numbers (ARR[i], ARR[il, ARR[k],
ARR[I]) such that (0 <=¡<j<k<|<N) and ARR[i] + ARR[i] + ARR[k] + ARR[!] =
'TARGET'
Note:
1. All four numbers should exist at different indices in the given array.


import java.io.*;
import java.util.* ;

public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      Arrays.sort(arr);
      for(int i=0;i<n-3;i++){
        if(i>0 && arr[i]==arr[i-1]) continue;
        for(int j=i+1;j<n-2;j++){
          if(j>i && arr[j] == arr[j-1]) continue;
          int k=j+1,l=n-1;
          while(k<l){
            if((arr[i]+arr[j]+arr[k]+arr[l])==target) return "Yes";
            else if((arr[i]+arr[j]+arr[k]+arr[l])<target){
              k++;
              while(k<l && arr[k]==arr[k-1]) k++;
            }
            else{
              l--;
              while(k<l && arr[l]==arr[l+1]) l--;
            }
          }
        }
      }
      return "No";
  }
}


*/