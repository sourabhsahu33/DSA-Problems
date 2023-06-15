//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static String longestPalin(String S){
      int fi = 0, fj = 0, j, k, n = S.length ();
    
        for (int i = 0; i < n; ++i)
        {
            // odd length palindrome with current index as center
            j = i - 1;
            k = i + 1;
            while (j >= 0 && k < n)
            {
                if (S.charAt(j) != S.charAt(k))
                    break;
                j--;
                k++;
            }
            if (k - j - 1 > fj - fi + 1)
            {
                fi = j + 1;
                fj = k - 1;
            }
    
            // even length palindrome if possible
            if (i < n - 1 && S.charAt(i) == S.charAt(i+1))
            {
                j = i - 1;
                k = i + 2;
                while (j >= 0 && k < n)
                {
                    if (S.charAt(j) != S.charAt(k))
                        break;
                    j--;
                    k++;
                }
                if (k - j - 1 > fj - fi + 1)
                {
                    fi = j + 1;
                    fj = k - 1;
                }
            }
        }
    
        return S.substring (fi, fj + 1);
        
    }
}