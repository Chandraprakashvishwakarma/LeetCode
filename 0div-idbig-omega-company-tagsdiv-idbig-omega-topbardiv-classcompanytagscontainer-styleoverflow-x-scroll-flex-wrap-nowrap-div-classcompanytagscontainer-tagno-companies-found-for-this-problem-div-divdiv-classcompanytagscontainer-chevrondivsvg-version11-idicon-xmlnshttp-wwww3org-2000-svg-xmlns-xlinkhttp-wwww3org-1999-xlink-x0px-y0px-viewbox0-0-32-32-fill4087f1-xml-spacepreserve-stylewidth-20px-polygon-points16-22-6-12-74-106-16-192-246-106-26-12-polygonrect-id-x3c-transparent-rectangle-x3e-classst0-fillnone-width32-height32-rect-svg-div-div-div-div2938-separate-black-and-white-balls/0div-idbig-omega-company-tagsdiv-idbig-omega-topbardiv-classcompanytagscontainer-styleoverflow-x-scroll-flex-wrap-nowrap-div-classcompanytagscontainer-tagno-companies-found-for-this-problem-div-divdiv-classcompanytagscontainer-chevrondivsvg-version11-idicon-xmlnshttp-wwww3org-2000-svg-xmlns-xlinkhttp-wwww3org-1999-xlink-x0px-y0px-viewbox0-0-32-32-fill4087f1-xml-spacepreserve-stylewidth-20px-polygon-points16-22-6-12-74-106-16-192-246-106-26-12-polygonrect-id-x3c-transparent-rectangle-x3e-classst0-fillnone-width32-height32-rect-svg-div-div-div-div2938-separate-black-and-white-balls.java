class Solution {
    public long minimumSteps(String s) {
        char [] a = s.toCharArray();
        int i = s.length()-1,j = s.length()-1;
        long ans = 0;
        while(i>=0 && a[i]=='1') {i--;j--;}
        while(i>=0 && j>=0){
            while(i>=0 && a[i]!='1') i--;
            while(j>=0 && a[j]!='0') j--;
            
            if(j<i) break;
            if(i>=0 && j>=0 && a[i] == '1' && a[j] == '0'){
                swap(i,j,a);
                ans+=(i-j);
            }
        }
        return Math.abs(ans);
    }
    
    public void swap(int i,int j,char [] a){
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}