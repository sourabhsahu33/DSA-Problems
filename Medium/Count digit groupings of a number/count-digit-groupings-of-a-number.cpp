//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
public:
int rec(int i,string &s,int last, vector<vector<int>> &dp){
    int n=s.size();
    if(i>=n){
        return 1;
    }
    if(dp[i][last]!=-1) return dp[i][last];
    int count=0;
    int sum=0;
    for(int j=i;j<s.size();j++){
        sum+=(s[j]-'0');
        if(sum>=last){
            count+=rec(j+1,s,sum,dp);
        }
    }
    return dp[i][last]=count;
}
int TotalCount(string s){
    int n=s.size();
    vector<vector<int>> dp(n+1,vector<int> (901,-1));
    return rec(0,s,0,dp);
}
 
};


//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string str;
		cin >> str;
		Solution ob;
		int ans = ob.TotalCount(str);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends