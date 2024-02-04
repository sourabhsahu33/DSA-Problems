//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    public static String smallestWindow(String s, String p)
    {int n = s.length();
        if (p.length() > n) return "-1"; // Handle case where t is longer than s
        
        Map<Character, Integer> map = new HashMap<>(); // Use Map for clarity
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int required = map.size(); // Number of distinct characters to match
        int i = 0, j = 0, minWindow = Integer.MAX_VALUE, start = 0;

        while (j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    required--;
                }
            }

            while (required == 0) {
                int currentWindow = j - i + 1;
                if (currentWindow < minWindow) {
                    minWindow = currentWindow;
                    start = i;
                }

                char leftChar = s.charAt(i);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        required++;
                    }
                }
                i++;
            }
            j++;
        }
        return minWindow == Integer.MAX_VALUE ? "-1" : s.substring(start, start + minWindow);
    }
}

