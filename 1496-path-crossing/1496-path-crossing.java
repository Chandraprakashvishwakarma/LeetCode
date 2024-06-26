class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        
        int x=0,y=0;
        set.add(x+","+y);
        for(char c:path.toCharArray()){
            if(c == 'N') y++;
            else if(c == 'S') y--;
            else if(c == 'E') x++;
            else if(c == 'W') x--;
            
            String s = x + "," + y;
            if (set.contains(s)) {
                return true;
            } else {
                set.add(s);
            }
            
        }
        return false;
    }
}