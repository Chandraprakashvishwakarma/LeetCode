class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        List<Integer> res = new ArrayList();
        int m = a.length, n = a[0].length;
        int top = 0, left = 0, bottom = m-1, right = n-1;
        int i=0,j=0;
        while(top<=bottom && left<=right){
            for(j=left;j<=right;j++) res.add(a[i][j]);
            j=right;
            top++;
            
            for(i=top;i<=bottom;i++) res.add(a[i][j]);
            i=bottom;
            right--;
            
            if(top>bottom) break;
            for(j=right;j>=left;j--) res.add(a[i][j]);
            j=left;
            bottom--;
            
            if(left>right) break;
            for(i=bottom;i>=top;i--) res.add(a[i][j]);
            i=top;
            left++;
        }
        return res;
    }
}