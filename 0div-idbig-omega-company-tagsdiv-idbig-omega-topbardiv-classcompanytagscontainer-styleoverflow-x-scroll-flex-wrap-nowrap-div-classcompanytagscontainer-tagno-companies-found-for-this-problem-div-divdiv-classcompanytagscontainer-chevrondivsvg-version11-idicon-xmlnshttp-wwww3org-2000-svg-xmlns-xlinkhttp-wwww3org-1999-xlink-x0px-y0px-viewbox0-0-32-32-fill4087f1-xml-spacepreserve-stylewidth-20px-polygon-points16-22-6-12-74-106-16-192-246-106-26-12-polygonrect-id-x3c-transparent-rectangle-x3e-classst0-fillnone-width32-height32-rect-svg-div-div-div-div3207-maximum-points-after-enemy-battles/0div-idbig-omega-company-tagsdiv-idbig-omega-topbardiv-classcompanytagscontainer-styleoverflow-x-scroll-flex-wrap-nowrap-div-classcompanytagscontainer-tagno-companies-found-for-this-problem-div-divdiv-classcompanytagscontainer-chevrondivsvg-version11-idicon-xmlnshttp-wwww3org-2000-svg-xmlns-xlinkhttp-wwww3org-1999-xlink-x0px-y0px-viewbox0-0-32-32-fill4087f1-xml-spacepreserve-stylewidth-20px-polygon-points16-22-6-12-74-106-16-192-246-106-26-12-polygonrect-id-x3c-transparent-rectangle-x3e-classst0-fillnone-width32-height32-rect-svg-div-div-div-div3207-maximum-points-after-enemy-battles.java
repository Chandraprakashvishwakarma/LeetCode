class Solution {
    public long maximumPoints(int[] enemy, int currentEnergy) {
        Arrays.sort(enemy);
        long cur = currentEnergy;
        long point=0;
        int n = enemy.length;
        int i =0,j=n-1;
        while(i<=j && enemy[i]<=cur){
            point = point + cur/enemy[i];
            cur = cur%enemy[i];
            
            if(cur<enemy[i]) cur = cur + enemy[j--];
        }
        return point;
    }
}