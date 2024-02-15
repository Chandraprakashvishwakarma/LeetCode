class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        List<Integer> one = new ArrayList();
        for(int i=0;i<n;i++) if(seats[i] == 1) one.add(i);
        int j = 0;
        int max = 0; 
        int l = -1, r = -1;
        
        for(int i=0;i<n;i++){
            if(j<one.size()) r = one.get(j);
            else if(j>=one.size()) r = -1;
            if(seats[i] == 1 && i == r){
                l = i;j++;
                continue;
            }
            int leftOne = Integer.MAX_VALUE,rightOne = Integer.MAX_VALUE;
            if(l!=-1) leftOne = i-l;
            if(r!=-1) rightOne = r-i;
            
            max = Math.max(max,Math.min(leftOne,rightOne));
        }
        return max;
    }
}