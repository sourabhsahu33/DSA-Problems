<h2><a href="https://www.geeksforgeeks.org/problems/knight-in-geekland--170647/1?timeMachineDate=2023-04-02">Knight in Geekland</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Knight is at <strong>(start_x,start_y)</strong> in Geekland which is represented by an <strong>NxM</strong> 2D matrix.<br>Each cell in the matrix contains some points. In the ith step, the knight can collect all the points from all the cells that can be visited in exactly i steps without revisiting any cell.<br>Also, the knight has some magical powers that enable him to fetch coins from the future i.e. If the knight can collect y coins in the xth step he can fetch all the coins that he will collect in the (x + y)th step and if the knight can collect z coins in the (x + y)th step he can fetch all the coins that he will collect in the (x + y + z)th step and so on without increasing the step count i.e. knight will stay on xth step and will get all the coins of the future steps mentioned above((x + y)th step coins + (x + y+z)th steps + ...).</span></p>
<p><span style="font-size: 18px;"><strong>For example</strong>, If in 1st step knight can collect 1 point, then knight will also collect all the points which are at (1+1)th step i.e. 2 steps, and if knight can collect 3 points in (1+1)th step then knight will also collect all the points at (1+1+3)th step and so on. Hence being only at the first step knight can collect overall 1+3 = 4 points if there are no points available at (1+1+3)th step.</span></p>
<p><span style="font-size: 18px;">Find the minimum number of steps required to collect the maximum points.<br><strong>Note:</strong> The <a href="https://en.wikipedia.org/wiki/Knight_(chess)#:~:text=Compared%20to%20other%20chess%20pieces,pieces%20to%20reach%20its%20destination.">knight moves</a> exactly the same as the knight on a chess board. Please follow 0 indexing.</span></p>
<p><span style="font-size: 18px;">Example 1:</span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>
n = 9
m = 10
start_x = 4, start_y = 5
arr =
0 0 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 0
0 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0
0 <span style="color: #00ff00;"><strong>2</strong></span> 0 0 <span style="color: #ff0000;"><strong>1</strong></span> <span style="color: #00ff00;"><strong>2</strong></span> <span style="color: #ff0000;"><strong>0</strong></span> 0 0 <span style="color: #00ff00;"><strong>2</strong></span>
0 0 <span style="color: #00ff00;"><strong>2</strong></span> <span style="color: #ff0000;"><strong>0</strong></span> <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> <span style="color: #ff0000;"><strong>0</strong></span> <span style="color: #00ff00;"><strong>2</strong></span> 0
0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #000000;"><strong><span style="background-color: #ffff00;">0</span></strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span>
0 0 <span style="color: #00ff00;"><strong>2</strong></span> <span style="color: #ff0000;"><strong>0</strong></span> <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> <span style="color: #ff0000;"><strong>0</strong></span> <span style="color: #00ff00;"><strong>2</strong></span> 0
0 <span style="color: #00ff00;"><strong>2</strong></span> 0 0 <span style="color: #ff0000;"><strong>0</strong></span> <span style="color: #00ff00;"><strong>2</strong></span> <span style="color: #ff0000;"><strong>0</strong></span> 0 0 <span style="color: #00ff00;"><strong>2</strong></span>
0 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0
0 0 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 <span style="color: #00ff00;"><strong>2</strong></span> 0 0
<strong>Output:</strong> 1
<strong>Explanation:</strong> minimum knight have to take 1 steps to gain maximum points.
Initially, the knight has 0 coins, he will take 1 step to collect 1 point (sum of cells denoted in red color).
Now in the second step, he can collect points from all the cells colored green i.e. 64 points.
But with his magical power, at the 1st step, he can fetch points from the (1 + 1)th step. Therefore he can collect 1 + 64 coins at step 1 only. Hence answer is 1.</span>
</pre>
<p><span style="font-size: 18px;">Example 2:</span></p>
<pre><span style="font-size: 18px;">Input:
n = 3 
m = 3
start_x = 2, start_y = 1
arr =
7 6 8
9 1 4
6 2 8
Output:0
Explanation:
Initially, the knight has 2 points, or more formally we can say that at the 0th step knight has 2 points.
In the first step, he can collect points from cells (0, 0) and (0, 2) i.e. 15 points.
In the second step, he can collect points from cells (1, 0) and (1, 2) i.e. 13 coins.
In the third step, he can collect points from cells (2, 0) and (2, 2) i.e. 14 points.
In the fourth step, he can collect points from the cell (0, 1) i.e. 6 points.
So in each step, he can collect coins like -You can see in the below image  Knight can collect 15 coins in the 0th step only
<img style="height: 430px; width: 500px;" src="https://media.geeksforgeeks.org/img-practice/rect46213-1668840290.png" alt=""></span>
</pre>
<p><span style="font-size: 18px;"><strong>Your Task:</strong><br>You don't need to read input or print anything. Your task is to complete the function knightInGeekland() which takes 2-d array <strong>arr[][],</strong>&nbsp;starting coordinates of knight <strong>start_x, and start_y&nbsp;</strong>as input, and return an integer value as min steps to gain max points.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong>&nbsp;O(N*M)<br><strong>Expected Auxiliary Space:</strong>&nbsp;O(N*M)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>&nbsp;&nbsp;&nbsp;1 &lt;= len(arr), len(arr[0])&nbsp;&lt;&nbsp;10<sup>3</sup><br>&nbsp; &nbsp;0&nbsp;&lt;= values in arr &lt;=100</span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Matrix</code>&nbsp;<code>BFS</code>&nbsp;