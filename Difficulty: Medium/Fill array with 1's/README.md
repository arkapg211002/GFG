<h2><a href="https://www.geeksforgeeks.org/problems/fill-array-by-1s0920/1?page=1&difficulty=Medium&status=unsolved&sortBy=submissions">Fill array with 1's</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 14pt;">You are given an array consisting of <code>0</code>s and <code>1</code>s. In each iteration, any <code>0</code> that is an immediate neighbor of a <code>1</code> can be converted to a <code>1</code>. Determine the minimum number of iterations required to convert the entire array to all <code>1</code>s. If it is not possible to convert the entire array to <code>1</code>s, return <code>-1</code>.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [1, 0, 1, 0]
<strong>Output: </strong>1
<strong>Explanation: </strong>Both the 0s has 1 as their immediate neighbour. So, only one iteration is required to fill the array with 1.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [0, 0, 1, 0, 0]</span>
<span style="font-size: 18px;"><strong>Output: 2</strong></span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [0, 0, 0]</span>
<span style="font-size: 18px;"><strong>Output: </strong>-1</span></pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(n)<br><strong>Expected Auxiliary Space:</strong> O(1)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= arr.size() &lt;= 10<sup>6</sup><br>0 &lt;= arr[i]<sub>&nbsp;</sub>&lt;= 1</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Mathematical</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;