class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int prof=0;
        for(int i=1;i<prices.length;i++){
            if(buy==prices[i]) continue;
            if(prices[i]<buy) buy=prices[i];
            prof=Math.max(prof,prices[i]-buy);
        } 
        return prof;
    }
}
