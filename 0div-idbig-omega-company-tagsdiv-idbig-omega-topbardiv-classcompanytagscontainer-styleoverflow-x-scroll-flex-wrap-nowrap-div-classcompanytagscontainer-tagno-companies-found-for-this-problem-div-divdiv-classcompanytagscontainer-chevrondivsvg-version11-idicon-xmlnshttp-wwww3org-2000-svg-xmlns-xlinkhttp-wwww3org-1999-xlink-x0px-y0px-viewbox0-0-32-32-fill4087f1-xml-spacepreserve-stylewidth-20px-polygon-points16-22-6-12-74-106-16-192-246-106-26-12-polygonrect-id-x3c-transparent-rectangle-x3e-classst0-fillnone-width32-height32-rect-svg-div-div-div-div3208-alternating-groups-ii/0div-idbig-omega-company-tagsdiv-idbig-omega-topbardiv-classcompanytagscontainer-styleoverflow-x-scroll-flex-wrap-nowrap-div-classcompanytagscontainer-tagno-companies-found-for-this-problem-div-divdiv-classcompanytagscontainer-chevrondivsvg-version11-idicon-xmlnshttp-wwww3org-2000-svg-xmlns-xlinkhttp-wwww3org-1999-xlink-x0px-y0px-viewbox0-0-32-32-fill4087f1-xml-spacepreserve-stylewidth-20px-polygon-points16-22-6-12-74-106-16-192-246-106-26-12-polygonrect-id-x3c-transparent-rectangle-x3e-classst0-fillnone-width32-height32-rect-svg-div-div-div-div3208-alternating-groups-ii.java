class Solution {
    public int numberOfAlternatingGroups(int[] color, int k) {
        int n = color.length;
        int i=0,j=0;
        int res=0;
        int pre = -1;
        while(i<n){
            while(i<n && j-i<k){
                if(color[j%n]==pre) {
                    i=j;
                    pre = -1;
                }
                else {
                    pre = color[j%n];
                    j++;
                }
            }
            if(j-i==k) res++;
            i++;
        }
        return res;
    }
}