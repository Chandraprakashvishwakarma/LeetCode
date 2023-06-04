/* 

https://www.youtube.com/watch?v=N0MgLvceX7M&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=28

*/

class Solution {
    public void setZeroes(int[][] a) {
        int col0=1;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==0) {
                    a[i][0]=0;
                    if(j==0) col0=0;
                    else a[0][j]=0;
                }
                
            }
        }
        for(int i=1;i<a.length;i++){
            for(int j=1;j<a[0].length;j++){
                if(a[i][0]==0 || a[0][j]==0) a[i][j]=0;
            }
        }

        if(a[0][0]==0) Arrays.fill(a[0],0);
        if(col0==0){
            for(int i=0;i<a.length;i++){
                a[i][0]=0;
            }
        }
    }
}