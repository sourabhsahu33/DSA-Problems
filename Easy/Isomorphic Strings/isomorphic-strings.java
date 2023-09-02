//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length() != str2.length()) return false;
        HashMap<Character,Character> maps1 = new HashMap<>();
        HashMap<Character,Character> maps2 = new HashMap<>();
        for(int i=0; i<str1.length(); i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            
            if(maps1.containsKey(c1)){
                if(maps1.get(c1) != c2) return false;
            }else{
                if(maps2.containsKey(c2)) return false;
                maps1.put(c1,c2);
                maps2.put(c2,c1);
            }
        }
        return true;
    }
}