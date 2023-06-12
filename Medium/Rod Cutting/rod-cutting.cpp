//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution{
    int t[1002][1002];
    
  public:
    int helper(int price[], int length[], int n, int i){
        if(n == 0 || i == 0) return 0; //Base case is there is no rod or there is not price then profit will be 0
        
        if(t[n][i] != -1) return t[n][i]; //Checking our cache for sub-problem
        
        if(length[n-1] <= i){
            //We can cut in current size or we cant cut in current size, Multiple sizes are allowed
            return t[n][i] = max(price[n-1]+helper(price, length, n, i-length[n-1]), helper(price, length, n-1, i));
        }
        
        //we cant cut in current size coz we dont hv enough size of rod
        else return t[n][i] = helper(price, length, n-1, i);
    }
  
    int cutRod(int price[], int n) {
        memset(t, -1, sizeof(t));
        //Creating a length array for simplicity of our approach
        int length[n];
        for(int i=0;i<n;i++) length[i] = i+1;
        return helper(price, length, n, n);
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) 
            cin >> a[i];
            
        Solution ob;

        cout << ob.cutRod(a, n) << endl;
    }
    return 0;
}
// } Driver Code Ends