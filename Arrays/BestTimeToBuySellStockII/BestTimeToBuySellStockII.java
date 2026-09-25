package BestTimeToBuySellStockII;

class Solution{
    public int maxProfit(int[] prices){
        int maxProfit=0;
        
        // prices = [7,1,5,3,6,4]
        //
        //            p
        // mp=mp+prices[i]-prices[i-1]=>
        // mp=0+5-1=4
        // mp=4;
        // mp=4+6-3=7
        
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit=maxProfit+prices[i]-prices[i-1];
            }
        }
        
        return maxProfit;
    }
}