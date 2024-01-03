//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  private:
    bool check(int start, int end, string s){
        bool z=false, o=false, t=false;
        for(int k=start; k<=end; k++){
            if(s[k]=='0') z=true;
            else if(s[k]=='1') o=true;
            else if(s[k]=='2') t=true;
            if(z && o && t) return true;
        }
        return false;
    }
  public:
    int smallestSubstring(string S) {
        // Code here
        int res=INT_MAX, n=S.size(), i=0, j=2, preIdx=0;
        while(preIdx<=n-3){
            if(check(i,j,S)) return j-i+1;
            if(j==n-1){
                preIdx++;
                j=j-i;
                i=-1;
            }
            i++, j++;
        }
        return -1;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin >> S;
        Solution ob;
        cout << ob.smallestSubstring(S);
        cout << endl;
    }
}
// } Driver Code Ends