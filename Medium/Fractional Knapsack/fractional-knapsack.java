//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    class ComparatorItem implements Comparator<Item> {
        @Override
        public int compare(Item min, Item max) {
            return Double.compare((double) max.value / max.weight, (double) min.value / min.weight);
        }
    }

    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        PriorityQueue<Item> pq = new PriorityQueue<>(new ComparatorItem());
        pq.addAll(Arrays.asList(arr));
        double ans = 0;
        while (W > 0 && !pq.isEmpty()) {
            Item top = pq.poll();
            if (top.weight <= W) {
                ans += top.value;
                W -= top.weight;
            } else {
                ans += (double) top.value / top.weight * W;
                W = 0;
            }
        }
        return ans;
    }
}