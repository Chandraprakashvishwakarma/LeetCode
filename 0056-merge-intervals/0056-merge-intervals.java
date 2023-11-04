class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <2) return intervals;
        Arrays.sort(intervals , (a,b)->a[0]-b[0]);
        
        List<int []> res = new ArrayList();
        int start =intervals[0][0] ,end = intervals[0][1];
        
        for(int [] ar : intervals){
            if(ar[0]>end){
                res.add(new int[]{start,end});
                start = ar[0];
                end = ar[1];
            }
            else{
                end = Math.max(end,ar[1]);
            }
        }
        res.add(new int[]{start,end});
        
        return res.toArray(new int[0][]);
    }
}