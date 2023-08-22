//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
            int arr[]=new int[N];
        int max=Integer.MIN_VALUE;
        int rowSumMax=Integer.MIN_VALUE;
        int colSumMax=Integer.MIN_VALUE;
        
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=0;j<N;j++){
                sum+=matrix[i][j];
            }
            arr[i]=sum;
            rowSumMax=Math.max(rowSumMax,sum);
        }
          for(int i=0;i<N;i++){
            int sum=0;
            for(int j=0;j<N;j++){
                sum+=matrix[j][i];
            }
            colSumMax=Math.max(colSumMax,sum);
        }
        
        int ans=0;
        max=Math.max(rowSumMax,colSumMax);
        for(int i=0;i<N;i++){
            ans+=(max-arr[i]);
        }
        return ans;
    }
}
        
