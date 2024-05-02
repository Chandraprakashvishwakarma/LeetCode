class Solution {
    public int findMaxK(int[] nums) {
        // Arrays.sort(nums);
        // int i=0,j = nums.length-1;
        // while(i<j){
        //     if(-nums[i] == nums[j]) return nums[j];
        //     else if(-nums[i]>nums[j]) i++;
        //     else j--;
        // }
        // return -1;
        
        // boolean a[] = new boolean [20002];
        // int max = -1;
        // for(int i:nums){
        //     a[1001+i] = true;
        //     if(a[1001-i] && a[1001+i]) max = Math.max(max,Math.abs(i));
        // }
        // return max;
        
        Map<Integer,Boolean> map = new HashMap<>();
        int max = -1;
        for(int i:nums){
            map.put(i,true);
            if(map.get(i) && map.getOrDefault(-i,false)) max = Math.max(max,Math.abs(i));
        }
        return max;
    }
}