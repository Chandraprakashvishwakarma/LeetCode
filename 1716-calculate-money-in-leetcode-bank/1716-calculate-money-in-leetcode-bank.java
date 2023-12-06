class Solution {
    public int totalMoney(int n) {
        int i=1;
        int res = 0;
        int days = 7;
        while(n>0){
            int j = i;
            days = 7;
            while(n>0 && days>0){
                res+=j;
                j++;
                days--;
                n--;
            }
            i++;
        }
        return res;
    }
}