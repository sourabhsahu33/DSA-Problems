//{ Driver Code Starts
//Initial Template for Java
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
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    void funct(int idx, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> ans){
        if(N == idx){
            ans.add(sum);
            return;
        }
        // pic element 
        funct(idx+1, sum+ arr.get(idx), arr, N, ans);
        // don't pic element 
        funct(idx+1, sum, arr, N, ans);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        funct(0,0, arr, N, ans);
        Collections.sort(ans);
        return ans;
    }
}