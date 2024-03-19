// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
//         int arrow = 1;
//         int pre = 0;
//         for(int i=1;i<points.length;i++){
//             if(points[i][0]>points[pre][1]){
//                 arrow++;
//                 pre=i;
//             }
//         }
//         return arrow;
//     }
// }


class Solution {
    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int s = points[0][0],e = points[0][1];
        int a = 1;
        for(int [] ar:points){
            if(ar[0]<=e) s = Math.max(s,ar[0]);
            else {
                a++;
                s = ar[0];
                e = ar[1];
            }
        }
        return a;
    }
}
    
