//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
private:
    int mod=1e9+7;
    long long helper(long long curr,int n,int cnt){
        if(cnt>n) return 0;
        long long res = 1;
        for(int i=0; i<cnt ; i++){
            res = (res*curr)%mod;
            curr++;
        }
        
        return (res+helper(curr,n,cnt+1))%mod;
    }
public:
    long long sequence(int n){
        return helper(1,n,1);
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        
        Solution ob;
        cout<<ob.sequence(N)<<endl;
    }
    return 0;
}
// } Driver Code Ends