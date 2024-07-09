class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        int time = 0;
        for(int [] cust:customers){
            time = Math.max(time,cust[0]);
            time = time+cust[1];
            totalWaitingTime += (time-cust[0]);
        }
        return totalWaitingTime/customers.length;
    }
}


