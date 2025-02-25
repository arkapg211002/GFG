<h2><a href="https://www.geeksforgeeks.org/problems/minimum-times-a-has-to-be-repeated-such-that-b-is-a-substring-of-it--170645/1?page=1&difficulty=Medium&status=unsolved&sortBy=submissions">Minimum times A has to be repeated such that B is a substring of it</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given two strings <strong>A </strong>and<strong> B. </strong>Find minimum number of times A has to be repeated such that B is a Substring of it. If <strong>B</strong> can never be a substring then return <strong>-1</strong>.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>A = "abcd"
B = "cdabcdab"
<strong>Output:
</strong>3
<strong>Explanation:</strong>
</span><span style="font-size:18px">Repeating A three times (abcdabcdabcd),
B is a substring of it. B is not a substring
of A when it is repeated less than 3 times.</span>
</pre>

<div><span style="font-size:18px"><strong>Example 2:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input:
</strong>A = "ab"
B = "cab"
<strong>Output :</strong>
-1</span>
<span style="font-size:18px"><strong>Explanation:</strong>
No matter how many times we repeat A, we can't
get a string such that B is a substring of it.</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>minRepeats()</strong>&nbsp;which takes 2 strings A, and B respectively and returns the minimum number of times A has to be repeated such that B is a substring of it. Return -1 if it's not possible.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(|A| * |B|)<br>
<strong>Expected Auxiliary Space:</strong> O(|B|)</span></p>

<div><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ |A|, |B| ≤ 10<sup>3</sup></span></div>

<div><span style="font-size:18px">String A and B consists of lower case alphabets</span></div>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Searching</code>&nbsp;<code>Strings</code>&nbsp;<code>Pattern Searching</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;