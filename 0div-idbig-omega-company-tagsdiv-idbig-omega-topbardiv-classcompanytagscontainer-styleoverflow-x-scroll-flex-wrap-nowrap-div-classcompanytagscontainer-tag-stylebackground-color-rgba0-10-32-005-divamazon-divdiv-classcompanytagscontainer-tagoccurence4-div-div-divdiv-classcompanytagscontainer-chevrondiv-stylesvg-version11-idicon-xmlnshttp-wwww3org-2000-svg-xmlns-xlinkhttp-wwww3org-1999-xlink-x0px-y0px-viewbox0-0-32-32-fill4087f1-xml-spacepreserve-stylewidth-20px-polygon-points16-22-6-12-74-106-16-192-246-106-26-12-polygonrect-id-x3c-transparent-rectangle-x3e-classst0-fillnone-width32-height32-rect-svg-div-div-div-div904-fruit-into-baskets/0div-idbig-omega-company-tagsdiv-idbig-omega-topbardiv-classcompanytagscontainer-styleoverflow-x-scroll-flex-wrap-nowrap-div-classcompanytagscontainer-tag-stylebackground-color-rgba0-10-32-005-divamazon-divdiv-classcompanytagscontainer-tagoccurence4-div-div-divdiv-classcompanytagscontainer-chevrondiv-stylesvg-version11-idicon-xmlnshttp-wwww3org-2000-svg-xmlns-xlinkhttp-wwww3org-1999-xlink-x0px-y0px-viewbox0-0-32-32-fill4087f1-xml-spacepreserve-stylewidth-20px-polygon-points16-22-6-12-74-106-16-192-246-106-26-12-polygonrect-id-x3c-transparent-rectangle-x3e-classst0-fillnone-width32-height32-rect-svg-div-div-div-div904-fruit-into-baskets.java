class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Set<Integer> set = new HashSet<>();
        int [] ar = new int [n];
        int i=0,j=0,max = 0;
        while(j<n){
            set.add(fruits[j]);
            ar[fruits[j]]++;
            while(set.size()>2){
                ar[fruits[i]]--;
                if(ar[fruits[i]] == 0) set.remove(fruits[i]);
                i++;
            }
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
