/*
Q. no. 18 : Reverse Pairs
*/

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    
    public int mergeSort(int [] nums,int low,int high){
        int inv_count=0;
        if(low<high){
        int mid = (high+low)/2;
        inv_count+=mergeSort(nums,low,mid);
        inv_count+=mergeSort(nums,mid+1,high);
        inv_count+=countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        }
        return inv_count;
    }
    public void merge(int [] nums,int low,int mid ,int high){
        int [] temp = new int[high-low+1];
        int k=0, l=low,r=mid+1;
        while(l<=mid && r<=high){
            if(nums[l]<=nums[r]){
                temp[k++] = nums[l++];
            }
            else {
                temp[k++] = nums[r++];
            }
        }
        while(l<=mid) temp[k++]=nums[l++];
        while(r<=high) temp[k++]=nums[r++];
        for(int i=0;i<temp.length;i++) nums[low+i] = temp[i];
    }
    public int countPairs(int [] nums,int low,int mid,int high){
        int inv_count=0;
        int r=mid+1;
        for(int l=low;l<=mid;l++){
            while(r<=high && 0.5*nums[l]>nums[r]) r++;
            inv_count+=(r-(mid+1));
        }
        return inv_count;
    }
}


/*
Codding Ninjas: 

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        return mergeSort(arr,0,arr.size()-1);
    }

    public static int mergeSort(ArrayList<Integer> arr , int low ,int high){
        int inv_count=0;
        if(low<high){
            int mid = (low+high)/2;
            inv_count+=mergeSort(arr,low,mid);
            inv_count+=mergeSort(arr, mid+1, high);
            inv_count+=merge(arr,low,mid,high);
        }
        return inv_count;
    }

    public static int merge(ArrayList<Integer> arr , int low, int mid ,int high){
        int count=0;
        List<Integer> temp = new ArrayList<>();
        int j = mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high && arr.get(i)>2*arr.get(j)) j++;
            count +=(j-(mid+1));
        }
        int l=low;j=mid+1;
        while(l<=mid && j<=high){
            if(arr.get(l)<=arr.get(j)) temp.add(arr.get(l++));
            else temp.add(arr.get(j++));
        }
        while(l<=mid) temp.add(arr.get(l++));
        while(j<=high) temp.add(arr.get(j++));

        for(int i=0;i<temp.size();i++) arr.set(low+i,temp.get(i));
        return count;
    }
}

*/