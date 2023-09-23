//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int target = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        		array[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.threeSumClosest(array,target));
            t--;
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int threeSumClosest(int[] array, int target)  
	{ 
       Arrays.sort(array);
       int n = array.length;
       int closestsum = Integer.MAX_VALUE;
       int mindiff = Integer.MAX_VALUE;
       for(int i=0; i<n-2; i++){
           int left = i+1;
           int right = n-1;
           while(left<right){
               int sum = array[i]+ array[left]+array[right];
               int diff = Math.abs(target - sum);
               if(diff<mindiff || (diff == mindiff && sum > closestsum)){
                   mindiff = diff;
                   closestsum = sum;
               }
               if(sum <target){
                   left++;
               }else{
                   right--;
               }
           }
       }
       return closestsum;
	} 
} 
