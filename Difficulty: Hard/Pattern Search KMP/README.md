<h2><a href="https://www.geeksforgeeks.org/problems/pattern-search-kmp/1?page=1&difficulty=Hard&status=unsolved&sortBy=accuracy">Pattern Search KMP</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a string <strong>S</strong> and a pattern <strong>P</strong> of all lowercase characters. The task is to check if the pattern exists in the string or not.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>S = aabaacaadaabaaba
P = aaaab
<strong>Output: </strong>No<strong>
Explanation: </strong>Given pattern is not found
in the given string S.</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>S = aabaacaadaabaaba
P = caada
<strong>Output: </strong>Yes<strong>
Explanation: </strong>Given pattern is found in
the given string S.</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
The task is to complete the function <strong>KMPSearch</strong>() which returns true or false depending on whether pattern is present in the string or not,&nbsp;and <strong>computeLPSArray</strong>() which computes the longest prefix suffix for every index.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(N+M).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(M).<br>
Note: N = |S|, M = |P|.</span></p>

<p><span style="font-size:18px"><strong>Constrsaints:</strong><br>
1 &lt;= |S|, |P| &lt;= 10<sup>4</sup></span></p>
</div>