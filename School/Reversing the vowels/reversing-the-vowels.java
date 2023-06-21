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
            String s;
            s = sc.next();
           
            Solution ob = new Solution();
            
            System.out.println(ob.modify(s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
     public boolean isVowel(char c){
        return(c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
    }
    
    String modify (String s)
    {
        // your code here
        int j=0;
        char str[] = s.toCharArray();
        String vowel = "";
        for(int i=0; i<str.length; i++){
            if(isVowel(str[i])){
                j++;
                vowel += str[i];
            }
        }
        for(int i=0; i<str.length; i++){
            if(isVowel(str[i])){
                str[i] = vowel.charAt(--j);
            }
        }
        return String.valueOf(str);
    }
}