//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static class Pair{
        int start;
        int end;
        int num;
        Pair(int start, int end, int num){
            this.start = start;
            this.end = end;
            this.num = num;
        }
    }
    public static class sortFunction implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            if(a.end>b.end) return 1;
            else if(a.end<b.end) return -1;
            else return 0;
        }
    }
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        ArrayList<Pair> meetings = new ArrayList<>();
        for(int i=0; i<N; i++){
            Pair p = new Pair(S[i], F[i], i+1);
            meetings.add(p);
        }
        meetings.sort(new sortFunction());
        ArrayList<Integer> list = new ArrayList<>();
        int endTime = -1;
        for(int i=0; i<N; i++){
            Pair time = meetings.get(i);
            int startTime = time.start;
            if(endTime<startTime){
                list.add(time.num);
                endTime = time.end;
            }
        }
        Collections.sort(list);
        return list;
    }
}     
