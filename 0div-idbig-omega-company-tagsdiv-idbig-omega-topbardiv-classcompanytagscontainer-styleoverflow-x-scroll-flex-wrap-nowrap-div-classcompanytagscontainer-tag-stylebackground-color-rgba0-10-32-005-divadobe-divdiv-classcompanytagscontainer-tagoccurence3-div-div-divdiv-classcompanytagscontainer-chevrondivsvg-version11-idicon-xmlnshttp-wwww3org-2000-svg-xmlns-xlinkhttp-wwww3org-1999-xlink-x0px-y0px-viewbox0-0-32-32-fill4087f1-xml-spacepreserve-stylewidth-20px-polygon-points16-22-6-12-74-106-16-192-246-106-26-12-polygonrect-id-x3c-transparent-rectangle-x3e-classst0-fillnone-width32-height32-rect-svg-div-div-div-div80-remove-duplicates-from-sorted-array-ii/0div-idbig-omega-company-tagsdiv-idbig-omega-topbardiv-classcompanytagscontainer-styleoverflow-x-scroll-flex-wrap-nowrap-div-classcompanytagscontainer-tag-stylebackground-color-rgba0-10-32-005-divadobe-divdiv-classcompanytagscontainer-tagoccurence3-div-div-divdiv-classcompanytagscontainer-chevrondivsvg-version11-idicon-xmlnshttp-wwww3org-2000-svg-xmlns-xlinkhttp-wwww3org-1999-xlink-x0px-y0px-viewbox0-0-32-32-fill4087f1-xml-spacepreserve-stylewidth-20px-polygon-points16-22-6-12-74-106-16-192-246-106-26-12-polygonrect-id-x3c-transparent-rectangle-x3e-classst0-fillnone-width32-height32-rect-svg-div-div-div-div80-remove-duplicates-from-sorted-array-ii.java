class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
//         int i=0,j=i+1;
//         int n=nums.length;
//         if(n<=2) return n;
//         int c=0;
//         int extraDuplicate = 0;
//         while(j<n-extraDuplicate){
//             if(nums[i]==nums[j]){
//                 if(c>0){
//                     extraDuplicate++;
//                     shiftToLast(j,nums);
//                 }
//                 else{
//                     j++;
//                     c++;
//                 }
//             }
//             else{
//                 c=0;
//                 i=j;
//                 j=i+1;
//             }
//         }
//         return n-extraDuplicate;
//     }
//     public void shiftToLast(int j,int nums[]){
//         while(j<nums.length-1){
//             int temp = nums[j];
//             nums[j] = nums[j+1];
//             nums[j+1] = temp;
//             j++;
//         }
//     }
// }
























