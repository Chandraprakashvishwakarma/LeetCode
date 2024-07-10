class Solution {
    public int minOperations(String[] logs) {
        int opNeeded = 0;
        for(String s:logs){
            if(s.equals("./")) continue;
            else if(!s.equals("../")) opNeeded++;
            else if(opNeeded>0) opNeeded--;
        }
        return opNeeded;
    }
}