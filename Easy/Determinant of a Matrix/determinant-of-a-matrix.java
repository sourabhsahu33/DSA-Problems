//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int mat[][], int n)
    {
        // code here 
        if(n == 1) return mat[0][0]; 
        if(n == 2){
            return (mat[0][0]*mat[1][1]) - (mat[0][1]*mat[1][0]);
        }
        int deter = 0;
        for(int i=0; i<n; i++){
            int[][] temp = new int[n-1][n-1];
            int r=0, c=0;
            for(int j=1; j<n; j++){
                for(int k=0; k<n; k++){
                    if(k==i) continue;
                    temp[r][c] = mat[j][k];
                    c++;
                }
                r++;
                c=0;
            }
            if(i%2 == 0)
                deter += mat[0][i] * determinantOfMatrix(temp, n-1);
            else
                deter -= mat[0][i] * determinantOfMatrix(temp, n-1);
        }
        return deter;
    }
}

