<h2><a href="https://www.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1?page=1&difficulty=Medium&status=unsolved&sortBy=submissions">Minimum Swaps for Bracket Balancing</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">You are given a string <strong>S</strong> of <strong>2*N</strong> characters consisting of <strong>N</strong> ‘<strong>[</strong>‘ brackets and <strong>N</strong> ‘<strong>]</strong>’ brackets. A string is considered <strong>balanced</strong> if it can be represented in the form <strong>S2[S1]</strong> where <strong>S1</strong> and <strong>S2</strong> are balanced strings. We can make an unbalanced string balanced by swapping <strong>adjacent</strong> characters. <br>Calculate the <strong>minimum number of swaps</strong> necessary to make a string balanced.<br><strong>Note - Strings S1 and S2 can be empty.</strong></span></p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input</strong>  : []][][
<strong>Output</strong> : 2
<strong>Explanation </strong>:
First swap: Position 3 and 4 [][]][
Second swap: Position 5 and 6 [][][]</span>
</pre>
<p><strong><span style="font-size: 18px;">Example 2:</span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input</strong> : c
<strong>Output</strong> : 0 
<strong>Explanation</strong>:
String is already balanced.</span></pre>
<p><strong><span style="font-size: 18px;">Your Task:</span></strong></p>
<p><span style="font-size: 18px;">You don't need to read input or print anything. Your task is to complete the function <strong>minimumNumberOfSwaps()</strong> which takes the string <strong>S</strong> and return minimum number of operations required to balance the bracket sequence.<br></span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(N)<br><strong>Expected Auxiliary Space:</strong> O(1)<br></span></p>
<p><span style="font-size: 18px;"><strong>Constraints:<br></strong></span><span style="font-size: 18px;">1&lt;=|S|&lt;=100000</span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Greedy</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;