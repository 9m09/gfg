// User function Template for Java
class Solution {
    int minCost(int[] height) {
        // code here
        int[] dp = new int[height.length];
        Arrays.fill(dp,-1);
        return help(dp,height.length-1,height);
    }
    int help(int[] dp,int n,int[] height){
        if(n==0)    return 0;
        // if(n==1)    return 1;
        if(dp[n]!=-1)   return dp[n];
        int two = Integer.MAX_VALUE;
        int one=Math.abs(height[n]-height[n-1])+help(dp,n-1,height);
        if(n-2>-1)
        two=Math.abs(height[n]-height[n-2])+help(dp,n-2,height);
        return  dp[n]=Math.min(one,two);
    }
    
}