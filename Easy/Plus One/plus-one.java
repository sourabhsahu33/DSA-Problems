//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0 ; i<N ; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<Integer> res = ob.increment(arr,N);
            
            for(int i=0; i<res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static ArrayList<Integer> increment(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // StringBuilder st = new StringBuilder();
        
        // for (int i = 0; i < N; i++) {
        //     st.append(arr.get(i));
        // }
        
        // String str = st.toString();
        // java.math.BigInteger num = new java.math.BigInteger(str); // Use BigInteger
        // java.math.BigInteger ans = num.add(java.math.BigInteger.ONE); // Use BigInteger for calculations
        // while (!ans.equals(java.math.BigInteger.ZERO)) {
        //     int rem = ans.mod(java.math.BigInteger.TEN).intValue(); // Convert remainder to int
        //     ans = ans.divide(java.math.BigInteger.TEN);
        //     list.add(rem);
        // }
        
        int carry = 1;
        for(int i= N-1; i>=0; i--){
            int digit = arr.get(i) + carry;
            carry = digit/10;
            list.add(digit % 10);
        }
        while(carry> 0){
            list.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(list);
        return list;
    }
}

