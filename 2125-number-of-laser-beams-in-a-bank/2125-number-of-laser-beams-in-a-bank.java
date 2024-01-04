class Solution {
    public int numberOfBeams(String[] bank) {
        int [] col = new int[bank.length];
        for(int j=0;j<bank.length;j++){
            for(int i=0;i<bank[j].length();i++){
                if(bank[j].charAt(i)=='1') col[j]++;
            }
        }
        int res = 0;
        for(int j=0;j<col.length;j++){
            if(col[j]==0) continue;
            for(int i=j+1;i<col.length;i++){
                if(col[i]==0) continue;
                res+=(col[i]*col[j]);
                break;
            }
        }
        return res;
    }
}