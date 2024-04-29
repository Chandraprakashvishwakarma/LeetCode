class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        int n = chalk.length;
        long sum = 0;
        for(int j:chalk) sum+=j;
        k = (int)(k%sum);
        while(k>0){
            if(chalk[i%n] <= k){
                k-=chalk[i%n];
                i++;
            }
            else return i%n;
        }
        return i%n;
    }
}