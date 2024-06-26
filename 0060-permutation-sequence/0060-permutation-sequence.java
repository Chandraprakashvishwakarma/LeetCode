class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList();
        int fact =1;
        for(int i=1;i<n;i++){
            fact*=i;
            nums.add(i);
        }
        nums.add(n);
        String res ="";
        k--;
        while(true){
            res=res+nums.get(k/fact);
            nums.remove(k/fact);
            if(nums.size()==0) break;
            k=k%fact;
            fact=fact/nums.size();
        }
        return res;
    }
}