//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
        int ans = 0, sign = 1, i= 0;
        int n = s.length();
        while(i< n && Character.isWhitespace(s.charAt(i))) i++;
        if(i<n && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        while(i<n){
            if( Character.isDigit(s.charAt(i))){
                int digit = s.charAt(i)-'0';
            ans = ans*10 + digit;
            i++;
            }else
            return -1;    
        }
        return ans*sign ;
    }
}
