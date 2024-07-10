class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int a = tops[0];
        int b = bottoms[0];
        
        for(int i=1;i<n;i++){
            // if a is not present in top and bottom then it can't be the same numbers
            if(a!=tops[i] && a!=bottoms[i])
                a = -1;
            // if b is not present in top and bottom then it can't be the same numbers
            if(b!=tops[i] && b!=bottoms[i])
                b = -1;
            //if a and b both are not present in top and bottom means it can not be made equal
            if(a==-1 && b ==-1) return -1;
        }
        
// if a and b both are there then check for tswap for "a" automatically other will be there in in bswap and vice versa
        a = a!=-1?a:b;
        int tswap = 0,bswap = 0;
        for(int i=0;i<n;i++){
            if(tops[i]!=a) tswap++;
            if(bottoms[i]!=a) bswap++;
        }
        return Math.min(tswap,bswap);
    }
}