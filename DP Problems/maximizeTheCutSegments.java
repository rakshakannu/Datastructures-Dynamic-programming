problem link: https://practice.geeksforgeeks.org/problems/cutted-segments1642/1#

class Solution
{
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int[] dp = new int[n+1];
        dp[0]=0;
        
        for(int i=1;i<=n;i++)
        {
            dp[i]=-1;
            if(i-x>=0)
            {
                dp[i]= Math.max(dp[i],dp[i-x]);
            }
            
            if(i-y>=0)
            {
                dp[i]= Math.max(dp[i],dp[i-y]);
            }
            
            if(i-z>=0)
            {
                dp[i]= Math.max(dp[i],dp[i-z]);
            }
            
            if(dp[i]!=-1)
            {
                dp[i]++;
            }
        }
        
        return Math.max(dp[n],0);
       //Your code here
    }
}
