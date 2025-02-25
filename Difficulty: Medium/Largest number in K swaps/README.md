<h2><a href="https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1?page=1&difficulty=Medium&status=unsolved&sortBy=submissions">Largest number in K swaps</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a number <strong>K </strong>and string <strong>str </strong>of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of <strong>str </strong>at most&nbsp;<strong>K </strong>times.</span></p>
<p><br><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:
</strong>K = 4
str = "1234567"
<strong>Output:</strong>
7654321<strong>
Explanation:
</strong>Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5</span>
</pre>
<p><span style="font-size: 18px;"><strong>Example 2:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:
</strong>K = 3
str = "3435335"
<strong>Output:
</strong>5543333
<strong>Explanation:
</strong>Three swaps can make the input
3435335 to 5543333, swapping 3 
with 5, 4 with 5 and finally 3 with 4</span> 
</pre>
<p><br><span style="font-size: 18px;"><strong>Your task:</strong><br>You don't have to read input or print anything. Your task is&nbsp;to complete the function <strong>findMaximumNum()&nbsp;</strong>which takes the string and an integer as input and returns a string containing the largest number formed by perfoming the swap operation at most k times.</span></p>
<p><br><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong>&nbsp;O(n!/(n-k)!) , where n = length of input string<br><strong>Expected Auxiliary Space:</strong>&nbsp;O(n)</span></p>
<p><br><span style="font-size: 18px;"><strong>Constraints</strong>:<br>1 ≤&nbsp;|str|<strong> </strong>≤ 30<br>1 ≤&nbsp;K<strong> </strong>≤ 10</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>MakeMyTrip</code>&nbsp;<code>Walmart</code>&nbsp;<code>Intuit</code>&nbsp;<code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Backtracking</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;