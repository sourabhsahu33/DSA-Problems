//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int solve(int arr[], int st, int en, int K, int ans){
        if(st <= en){
            int mid = st+ (en-st)/2;
            if(isPoss(arr, K, mid)){
                ans = mid;
                return solve(arr, st, mid-1, K, ans);
            }else{
                return solve(arr, mid+1, en, K, ans);
            }
           
        } return ans;
    }
    public static boolean isPoss(int arr[], int K, int mid){
        int k_cnt = 1, subarr = 0;
        for(int i=0; i<arr.length; i++){
            if(subarr + arr[i] <= mid){
                subarr += arr[i];
            }else{
                k_cnt++;
                if(k_cnt > K || arr[i]> mid) return false;
                
                subarr = arr[i];
            }
        }
        return true;
    }
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int sum =0;
        for(int i=0; i<N; i++) 
        sum += arr[i];
        
        return solve(arr, arr[N-1], sum, K, -1);
    }
};