// User function Template for Java

class Solution {
    public int longestCommonSubstr(String t1, String t2) {
        // code here
        int n = t1.length();
        int m = t2.length();
        
        int[][] dp = new int[n+1][m+1];
        int max=0;
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t1.charAt(i-1) == t2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max=Math.max(max,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }
}