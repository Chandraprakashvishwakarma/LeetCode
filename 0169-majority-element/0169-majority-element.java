class Solution {
    public int majorityElement(int[] nums) {
        int c=0,el=nums[0];
        for(int i:nums){
            if(c == 0){
                el=i;c=1;
            }
            else if(i==el) c++;
            else c--;
            
        }
        return el;
    }
}