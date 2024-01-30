//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int dp[][][] = new int[n1][n2][n3];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        return solve(A,B,C,0,0,0,dp);
        
    }
    public static int solve(String A,String B,String C,int i,int j,int k,int dp[][][]){
        if(i == A.length() || j == B.length() || k == C.length()){
            return 0;
        }
        if(A.charAt(i) == B.charAt(j) && B.charAt(j) == C.charAt(k) && A.charAt(i) == C.charAt(k)){
            return dp[i][j][k] = 1 + solve(A,B,C,i+1,j+1,k+1,dp); 
        }
        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }
        int l = solve(A,B,C,i+1,j,k,dp);
        int r = solve(A,B,C,i,j+1,k,dp);
        int s = solve(A,B,C,i,j,k+1,dp);
        ArrayList<Integer> al = new ArrayList<>();
        al.add(l);al.add(r);al.add(s);
        Collections.sort(al);
        return dp[i][j][k] = al.get(al.size()-1);
    }
}