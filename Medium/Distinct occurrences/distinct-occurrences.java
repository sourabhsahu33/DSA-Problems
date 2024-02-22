//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends

class Solution
{
    int m;
    int n;
    int memo[][];
    int mod=(int)(1e9+7);
    int  subsequenceCount(String s, String t)
    {
    // Your code here
    m=s.length();
    n=t.length();
    memo=new int[m+1][n+1];
    for(int mem[]:memo)Arrays.fill(mem,-1);
       return solve(s,t,0,0);
    }
    int solve(String s,String t,int i,int j){
        if(j>=n)return 1;
        if(i>=m)return 0;
        
        if(memo[i][j]!=-1)return memo[i][j];
        int countways=0;
        
        if(t.charAt(j)==s.charAt(i)){
            //here we have two ways either we take this or skip
            countways=(countways%mod+solve(s,t,i+1,j)%mod)%mod;
            countways=(countways%mod+solve(s,t,i+1,j+1)%mod)%mod;
        }
        else countways=(countways%mod+solve(s,t,i+1,j)%mod)%mod;
        
        return memo[i][j]= countways;
    }
}