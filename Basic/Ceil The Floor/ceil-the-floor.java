//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends


class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        Pair p = new Pair();
        int diffmax = 10000000;
        int diffmin = 10000000;
        p.ceil = -1;
        p.floor = -1;
        for(int i = 0 ; i < n ; i++)
        {
            if(arr[i] >= x)
            {
                int temp = arr[i] - x;
                if(temp < diffmax)
                {
                    p.ceil = arr[i];
                    diffmax = temp;
                }
            }
            if(arr[i] <= x)
            {
                int temp = x-arr[i];
                if(temp < diffmin)
                {
                    p.floor = arr[i];
                    diffmin = temp;
                }
            }
            
        }
        return p;
    }
}

