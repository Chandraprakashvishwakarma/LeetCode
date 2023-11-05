/*
Q. no. 13: Search a 2D Matrix
*/
class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        int l = 0,h= a.length*a[0].length-1;
        while(l<=h){
            int mid = (l+h)/2;
            int r = mid/a[0].length;
            int c = mid%a[0].length;
            
            if(a[r][c] == target) return true;
            else if(a[r][c] < target) l = mid+1;
            else h = mid-1;
        }
        return false;
    }
}

/*
Codding Ninjas Solution :

import java.util.ArrayList;
public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int r = mat.size(), c = mat.get(0).size(),low =0,high = (r*c)-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(mat.get(mid/c).get(mid%c)==target) return true;
            else if(mat.get(mid/c).get(mid%c)<target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}




GFG solution :

        int i=0,j=m-1;
	    while(i<n && j>=0){
	        if(matrix[i][j]==x) return true;
	        if(matrix[i][j]<x) i++;
	        else j--;
	    }
	    return false;
*/