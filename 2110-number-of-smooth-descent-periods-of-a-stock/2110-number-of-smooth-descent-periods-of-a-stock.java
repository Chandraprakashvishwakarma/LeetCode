class Solution {
    public long getDescentPeriods(int[] a) {
        int end =0,start=0;
        long ans=0;
        int n = a.length;
        while(end<n){
            if(start == end ) {
                ans++;end++;
            }
            else if(a[end]+1 == a[end-1]) {
                ans = ans + (end - start + 1);
                end++;
            }
            else start = end;
        }
        return ans;
    }
}