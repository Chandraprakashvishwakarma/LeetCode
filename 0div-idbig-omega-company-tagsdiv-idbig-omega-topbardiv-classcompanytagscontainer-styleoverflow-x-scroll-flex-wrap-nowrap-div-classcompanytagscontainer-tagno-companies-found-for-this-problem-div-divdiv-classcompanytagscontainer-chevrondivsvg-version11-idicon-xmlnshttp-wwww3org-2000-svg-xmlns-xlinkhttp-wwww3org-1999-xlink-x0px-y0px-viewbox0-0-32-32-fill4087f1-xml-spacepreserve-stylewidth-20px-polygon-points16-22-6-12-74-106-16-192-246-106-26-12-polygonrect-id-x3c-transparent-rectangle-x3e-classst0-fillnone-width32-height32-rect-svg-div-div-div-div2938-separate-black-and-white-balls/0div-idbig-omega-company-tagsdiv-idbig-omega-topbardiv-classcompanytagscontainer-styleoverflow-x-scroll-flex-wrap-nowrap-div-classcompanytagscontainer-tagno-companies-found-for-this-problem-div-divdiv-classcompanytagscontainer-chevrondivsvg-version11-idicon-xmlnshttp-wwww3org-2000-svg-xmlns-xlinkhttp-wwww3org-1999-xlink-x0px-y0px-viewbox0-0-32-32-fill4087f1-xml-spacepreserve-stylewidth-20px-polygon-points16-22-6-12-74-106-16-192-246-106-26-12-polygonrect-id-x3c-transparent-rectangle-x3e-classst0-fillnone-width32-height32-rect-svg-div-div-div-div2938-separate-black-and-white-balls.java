class Solution {
    public long minimumSteps(String s) {
        int swapsNeedsToPlaceZeroToLeft = 0;
        long totalSwapsNeeded = 0;
        for(char c:s.toCharArray()){
            if(c=='1') swapsNeedsToPlaceZeroToLeft++;
            else totalSwapsNeeded+=swapsNeedsToPlaceZeroToLeft;
        }
        return totalSwapsNeeded;
    }
}