problem link: https://leetcode.com/problems/partition-equal-subset-sum/
problem link: https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1

public class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum=0;
        for(int i=0;i<N;i++)
        {
            sum = sum + arr[i];
        }
        
        if(sum%2==0){
            return subsetSum(arr,N,sum);
        }
        
        return 0;
    }

    static int subsetSum(int arr[], int N, int sum)
    {
        boolean dp[][] = new boolean[sum/2+1][N+1];
        
        for(int i=0;i<=N;i++){
            dp[0][i]=true;
        }
        
        for(int i=1;i<=sum/2;i++){
            dp[i][0]=false;
        }
        
        for(int i=1;i<=sum/2;i++){
            for(int j=1;j<=N;j++){
                dp[i][j]=dp[i][j-1];
                if (i >= arr[j-1]) 
                    dp[i][j] = dp[i][j] || dp[i - arr[j-1]][j-1]; 
            }
        }
        
        if(dp[sum/2][N]==true){
            return 1;
        }
        else{
            return 0;
        }
        
    }
}
