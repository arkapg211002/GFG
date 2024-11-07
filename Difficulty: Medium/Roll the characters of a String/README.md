<h2><a href="https://www.geeksforgeeks.org/problems/roll-the-characters-of-a-string2127/1?page=1&difficulty=Medium&status=unsolved&sortBy=submissions">Roll the characters of a String</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a string <strong>s </strong>containing lowercase alphabets and an array roll where <strong>roll[i]</strong> represents rolling the first <strong>roll[i]</strong> characters in the string, the task is to apply every roll[i] on the string and return the final string. Rolling means increasing the ASCII value of the character; for example, rolling z would result in a, rolling b would result in c, etc.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> s = "bca", roll[] = [1, 2, 3]
<strong>Output:</strong> eeb
<strong>Explanation</strong>: arr[0] = 1 means roll first character of string -&gt; cca <br>arr[1] = 2 means roll first two characters of string -&gt; dda
arr[2] = 3 means roll first three characters of string -&gt; eeb
So final ans is "eeb".</span><span style="font-size: 18px;">&nbsp;<br></span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>s = "zcza", roll[] = [1, 1, 3, 4]
<strong>Output: </strong>debb</span></pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(n).&nbsp;<br><strong>Expected Auxiliary Space:</strong> O(n).</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ s.size() ≤ 10<sup>6<br></sup>1 ≤ roll.size() ≤ 10<sup>6<br></sup>1 ≤ roll[i] ≤ s.size()<sup><br></sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Airtel</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Strings</code>&nbsp;<code>Data Structures</code>&nbsp;