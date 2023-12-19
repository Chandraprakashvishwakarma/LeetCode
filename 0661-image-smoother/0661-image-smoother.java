class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length,n = img[0].length;
        int [][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = getSmootherVal(img,i,j,m,n);
            }
        }
        return res;
    }
    public int getSmootherVal(int [][] img,int i,int j,int m,int n){
        long res = img[i][j];
        int count = 1;
        
        if(i-1>=0 && i-1<m && j>=0 && j<n) {res+=img[i-1][j];count++;}
        if(i-1>=0 && i-1<m && j-1>=0 && j-1<n) {res+=img[i-1][j-1];count++;}
        if(i-1>=0 && i-1<m && j+1>=0 && j+1<n) {res+=img[i-1][j+1];count++;}
        
        if(i>=0 && i<m && j-1>=0 && j-1<n) {res+=img[i][j-1];count++;}
        if(i>=0 && i<m && j+1>=0 && j+1<n) {res+=img[i][j+1];count++;}
        
        if(i+1>=0 && i+1<m && j-1>=0 && j-1<n) {res+=img[i+1][j-1];count++;}
        if(i+1>=0 && i+1<m && j>=0 && j<n) {res+=img[i+1][j];count++;}
        if(i+1>=0 && i+1<m && j+1>=0 && j+1<n) {res+=img[i+1][j+1];count++;}
        
        return (int)res/count; 
    }
}