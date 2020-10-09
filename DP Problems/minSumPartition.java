problem link: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1

class Solution
{
	public int minDiffernce(int arr[], int n) 
	{
	    int sum=0;
	    for(int i=0;i<n;i++){
	        sum = sum+arr[i];
	    }
	    
	    boolean dp[][] = new boolean[n+1][sum+1];
	    
	    //initialize first coloum as true
	    // zero sum is possible with all the elements
	    for(int i=0;i<=n;i++){
	        dp[i][0]=true;
	    }
	    
	    // initialize first row as false exept dp[0][0]
	    for(int i=1;i<=sum;i++){
	        dp[0][i]=false;
	    }
	    
	    //filling the dp matrix
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=sum;j++){
	            
	            dp[i][j]= dp[i-1][j];
	            
	            if(arr[i-1]<=j){
	                dp[i][j] =dp[i][j] || dp[i-1][j-arr[i-1]];
	            }
	        }
	    }
	    
	    int min= Integer.MAX_VALUE;
	    
	    //s1 will lie only within the first half
	    for(int j=sum/2;j>=0;j--){
	        if(dp[n][j]==true){
	            min=sum - 2*j; // finding min value
	            break;
	        }
	    }
	    return min;
    }
}

