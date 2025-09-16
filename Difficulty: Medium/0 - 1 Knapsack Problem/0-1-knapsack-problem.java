class Solution {
    static int knapsack(int w, int val[], int wt[]) {
        // code here
        int[][] dp=new int[val.length][w+1];
        for(int[] i:dp)   Arrays.fill(i,-1);
        
        return help(val.length-1,dp,val,wt,w);
        
    }
    static int help(int index,int[][] dp, int[] val, int[] wt,int w){
        
        if(dp[index][w]!=-1)  return dp[index][w];
        
        if(w==0)    return 0;
        
        if(index==0){
            if(wt[0]<=w){
                return val[0];
            }
            else return 0;
        }
        
        int not=help(index-1,dp,val,wt,w);
        int pick=Integer.MIN_VALUE;
        if(w>=wt[index]){
            pick=val[index]+help(index-1,dp,val,wt,w-wt[index]);
        }
        return dp[index][w]=Math.max(not,pick);
    }
}
