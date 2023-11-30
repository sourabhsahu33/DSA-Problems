//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends

class Pair{
    int x;
    int y;
    int steps;
    Pair(int x, int y, int steps){
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}
class Solution{
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start_x, start_y, 0));
        int [] delRow = {-2, -2, -1, +1, +2, +2, +1, -1};
        int [] delCol = {-1, +1, +2, +2, +1, -1, -2, -2};
        int N = arr.length, M = arr[0].length;
        int [][] visited =new int[N][M];
        visited[start_x][start_y]= 1;
        int [] coins = new int[1001];
        
        int step = 0;
        while(!queue.isEmpty()){
            int points = 0;
            int size = queue.size();
            while(size>0){
                Pair p = queue.remove();
                coins[p.steps] += arr[p.x][p.y];
                for(int i=0; i< 8; i++){
                    int NRow = delRow[i] + p.x;
                    int NCol = delCol[i] + p.y;
                    while(NRow >= 0 && NRow < N && NCol >= 0 && NCol < M 
                    && visited[NRow][NCol] == 0){
                        queue.add(new Pair(NRow, NCol, p.steps+1));
                        visited[NRow][NCol] = 1;
                    }
                }
                size--;
            }
            
            step++;
        }
        int minStep=0, maxcoins = Integer.MIN_VALUE;
        for(int i=0; i<=1000; i++){
            int curr = i;
            int totalPoint = 0;
            while(curr <= 1000){
                if(coins[curr] == 0) break;
                totalPoint  += coins[curr];
                curr += coins[curr];
            }
            coins[i] = totalPoint;
            if(coins[i] > maxcoins){
                maxcoins= coins[i];
                minStep = i;
            }
           
        }
        return minStep;
    }
}   