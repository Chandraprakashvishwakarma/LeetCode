class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length < 3) {
            return fruits.length;
        }
        
        int p1 = 0;
        int p2 = 0;
        int v1 = fruits[0];
        int v2 = fruits[0];
        int max = 1;
        
        for(int i = 1; i < fruits.length; i++) {
            if(fruits[i] != v1 && fruits[i] != v2){
                p1 = p2;
                p2 = i;
                v1 = fruits[i - 1];
                v2 = fruits[i];
            } else if(fruits[i] != fruits[i - 1]) {
                p2 = i;
            }
            
            max = Math.max(max, i - p1 + 1);
        }
        
        return max;
    }
}