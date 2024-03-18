//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	int  select(int arr[], int i)
	{
		int max = arr[0], ind = 0;
		for(int j=1; j<=i; j++)
		{
			if(arr[j]>max) 
			{
				ind = j; 
				max = arr[j]; 
			}
		}
		return ind; 
	}
	
	void selectionSort(int arr[], int n)
	{
		
		for(int i=n-1; i>=0; i--) 
		{
			int j = select(arr, i); 
			
			int temp = arr[i]; 
			arr[i] = arr[j];
			arr[j] = temp;
		}	
	}
}