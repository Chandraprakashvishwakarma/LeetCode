class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length,n = mat[0].length;
        
         //binary search on col
        int l = 0,h = n-1;
        while(l<=h){
            int mid = (l+h)/2;
            
            //finds row index of max element in col = mid
            int row = getInxOfMaxInCol(mat,mid);
            
            //for all the edge element  
            int left = mid-1>=0?mat[row][mid-1]:-1;
            int right = mid+1<n?mat[row][mid+1]:-1;

            if(mat[row][mid]>left && mat[row][mid]>right) return new int []{row,mid};
            else if(mat[row][mid]>left) l = mid+1;
            else h = mid-1;
        }
        return new int[] {-1,-1};
    }
    
    //max element in row can be peak
    public int getInxOfMaxInCol(int [][] mat,int col) {
        int max = -1;
        int idx = -1;
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]>max){
                max = mat[i][col];
                idx = i;
            }
        }
        return idx;
    }
}

//edges cases
// [[1,4],[3,2]]
// [[10,20,15],[21,30,14],[7,16,32]]
// [[10,50,40,30,20],[1,500,2,3,4]]
// [[7,2,3,1,2],[6,5,4,2,1]]
// [[1,2,3,4,5,6,7,8],[2,3,4,5,6,7,8,9],[3,4,5,6,7,8,9,10],[4,5,6,7,8,9,10,11]]