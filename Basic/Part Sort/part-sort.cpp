//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;



// } Driver Code Ends
//User function template for C++
class Solution{
public:		
	
	void partSort(vector<int> &arr, int n, int l, int r)
	{
	    if (l > r)
	       
	       sort(arr.begin() + r, arr.begin() + l + 1);
	    else
	 
	       sort(arr.begin() + l, arr.begin() + r + 1);
	}
};

//{ Driver Code Starts.


int main() 
{
   	ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;

        vector<int> arr(n);
        for(int i = 0; i < n; i++)
        	cin >> arr[i];

        int l, r;
        cin >> l >> r;

        Solution ob;

        ob.partSort(arr, n, l, r);

        for(int i = 0; i < n; i++)
        	cout << arr[i] << " ";

        cout << "\n";
    }

    return 0;
}
// } Driver Code Ends