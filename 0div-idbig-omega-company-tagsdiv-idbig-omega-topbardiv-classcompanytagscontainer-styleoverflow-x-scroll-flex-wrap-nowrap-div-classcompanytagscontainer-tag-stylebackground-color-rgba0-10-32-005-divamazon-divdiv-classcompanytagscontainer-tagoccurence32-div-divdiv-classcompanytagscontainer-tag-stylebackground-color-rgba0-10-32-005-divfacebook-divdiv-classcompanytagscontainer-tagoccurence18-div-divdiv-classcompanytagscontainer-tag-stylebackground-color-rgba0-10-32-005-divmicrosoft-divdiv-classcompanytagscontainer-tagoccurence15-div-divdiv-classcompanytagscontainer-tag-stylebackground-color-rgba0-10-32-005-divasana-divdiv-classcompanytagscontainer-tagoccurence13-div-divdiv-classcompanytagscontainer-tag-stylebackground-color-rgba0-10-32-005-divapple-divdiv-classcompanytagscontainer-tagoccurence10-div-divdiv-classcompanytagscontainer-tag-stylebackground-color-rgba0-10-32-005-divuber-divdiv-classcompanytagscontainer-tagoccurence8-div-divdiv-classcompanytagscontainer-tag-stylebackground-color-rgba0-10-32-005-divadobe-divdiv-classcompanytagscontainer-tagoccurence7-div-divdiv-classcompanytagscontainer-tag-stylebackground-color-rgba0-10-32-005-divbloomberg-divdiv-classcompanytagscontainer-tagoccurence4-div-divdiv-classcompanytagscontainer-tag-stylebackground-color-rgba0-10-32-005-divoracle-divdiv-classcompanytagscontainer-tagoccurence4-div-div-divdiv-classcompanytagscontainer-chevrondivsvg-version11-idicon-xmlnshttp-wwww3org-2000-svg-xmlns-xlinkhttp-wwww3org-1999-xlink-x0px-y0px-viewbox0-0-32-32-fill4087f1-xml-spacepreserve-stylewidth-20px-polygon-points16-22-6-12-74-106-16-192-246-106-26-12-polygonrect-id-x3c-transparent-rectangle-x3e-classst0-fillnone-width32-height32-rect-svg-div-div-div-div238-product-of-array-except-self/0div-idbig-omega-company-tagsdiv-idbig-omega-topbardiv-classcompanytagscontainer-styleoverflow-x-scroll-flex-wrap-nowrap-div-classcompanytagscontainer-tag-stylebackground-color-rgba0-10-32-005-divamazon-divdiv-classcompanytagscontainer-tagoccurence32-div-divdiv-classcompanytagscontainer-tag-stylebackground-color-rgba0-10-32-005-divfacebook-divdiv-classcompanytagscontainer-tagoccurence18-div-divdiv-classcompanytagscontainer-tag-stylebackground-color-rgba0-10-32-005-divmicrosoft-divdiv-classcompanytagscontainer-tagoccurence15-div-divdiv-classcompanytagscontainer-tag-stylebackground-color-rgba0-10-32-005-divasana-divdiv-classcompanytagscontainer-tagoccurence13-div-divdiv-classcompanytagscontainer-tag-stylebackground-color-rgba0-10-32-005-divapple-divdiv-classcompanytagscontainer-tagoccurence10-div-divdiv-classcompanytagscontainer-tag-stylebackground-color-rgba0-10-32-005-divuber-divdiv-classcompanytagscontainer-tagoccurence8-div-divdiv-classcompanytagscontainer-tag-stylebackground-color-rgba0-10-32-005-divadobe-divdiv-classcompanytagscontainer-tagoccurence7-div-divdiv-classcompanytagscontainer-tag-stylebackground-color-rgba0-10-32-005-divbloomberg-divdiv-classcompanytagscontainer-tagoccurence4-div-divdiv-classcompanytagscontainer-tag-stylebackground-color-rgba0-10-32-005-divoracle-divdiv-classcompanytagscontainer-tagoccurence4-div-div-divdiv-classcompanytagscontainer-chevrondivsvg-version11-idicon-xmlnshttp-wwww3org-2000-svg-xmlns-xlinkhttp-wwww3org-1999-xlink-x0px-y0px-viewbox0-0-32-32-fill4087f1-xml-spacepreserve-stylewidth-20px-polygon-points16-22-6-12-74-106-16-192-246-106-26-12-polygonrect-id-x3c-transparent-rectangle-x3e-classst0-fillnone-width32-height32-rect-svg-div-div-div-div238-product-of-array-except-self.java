class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length,z=0;
        int [] suffixProd = new int [n];
        suffixProd[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i] == 0) z++;
            if(z>1) return new int [n];
             suffixProd[i] = suffixProd[i+1]*nums[i];
        }
        int [] res = new int[n];
        int prod = 1;
        for(int i=0;i<n-1;i++){
            res[i] = suffixProd[i+1] * prod;
            prod = prod * nums[i];
        }
        res[n-1] = prod;
        return res;
    }
}