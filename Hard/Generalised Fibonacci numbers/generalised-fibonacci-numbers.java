//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            long a = Long.parseLong(S[0]);
            long b = Long.parseLong(S[1]);
            long c = Long.parseLong(S[2]);
            long n = Long.parseLong(S[3]);
            long m = Long.parseLong(S[4]);

            Solution ob = new Solution();
            System.out.println(ob.genFibNum(a,b,c,n,m));
        }
    }
}
// } Driver Code Ends


class Solution {
    long MOD = 1000000007;

    long[][] multiply(long[][] mat1, long[][] mat2, long m) {
        int size = mat1.length;
        long[][] ans = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    ans[i][j] = (ans[i][j] + (mat1[i][k] * mat2[k][j]) % m) % m;
                }
            }
        }
        return ans;
    }

    long[][] matrixMult(long[][] mat, long n, long m) {
        if (n == 1) {
            return mat;
        }
        long[][] prod = matrixMult(mat, n / 2, m);
        prod = multiply(prod, prod, m);
        if (n % 2 == 1) {
            prod = multiply(prod, mat, m);
        }
        return prod;
    }

    long genFibNum(long a, long b, long c, long n, long m) {
        if (n <= 2) {
            return 1;
        }
        long[][] v = new long[3][3];
        v[0][0] = a;
        v[0][1] = b;
        v[0][2] = 1;
        v[1][0] = 1;
        v[2][2] = 1;
        v = matrixMult(v, n - 2, m);
        return (v[0][0] + v[0][1] + c * v[0][2]) % m;
    }
}