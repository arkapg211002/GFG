<h2><a href="https://www.geeksforgeeks.org/problems/minimum-number-of-sprinkler--170645/1?page=1&difficulty=Hard&status=unsolved&sortBy=submissions">Minimum Number Of Sprinkler</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">There is a one-dimensional garden of length&nbsp;<strong>N</strong>. In each position of the&nbsp;<strong>N</strong>&nbsp;length garden, a sprinkler has been installed. Given an&nbsp;<a href="https://www.geeksforgeeks.org/array-data-structure/">array</a>&nbsp;<strong>a[]</strong>such that&nbsp;<strong>a[i]</strong>&nbsp;describes the coverage limit of the&nbsp;<strong>i<sup>th</sup></strong>&nbsp;sprinkler. A sprinkler&nbsp;can cover the range from the position&nbsp;<strong>max(i - a[i], 1)</strong>&nbsp;to&nbsp;<strong>min(i + a[i], N)</strong>. In beginning, all the sprinklers&nbsp;are switched off.<br>The task is to find the minimum number of sprinklers needed to be activated such that the whole<strong>&nbsp;N</strong>-length garden can be covered by water.<br><strong>Note:&nbsp; Array is 1-based indexed.</strong></span></p>
<p><strong><span style="font-size: 18px;">Example 1:</span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>&nbsp;a[] = {1, 2, 1}
<strong>Output:</strong>&nbsp;1
<strong>Explanation:</strong>
For position 1: a[1] = 1, range = 1 to 2
For position 2: a[2] = 2, range = 1 to 3
For position 3: a[3] = 1, range = 2 to 3
Therefore, the fountain at position a[2] covers
the whole garden. Therefore, the required output is 1.</span>

</pre>
<p><strong><span style="font-size: 18px;">Example 2:</span></strong></p>
<pre><strong><span style="font-size: 18px;">Input: </span></strong><span style="font-size: 18px;">a[] = {2, 1, 1, 2, 1}&nbsp;
</span><strong><span style="font-size: 18px;">Output: </span></strong><span style="font-size: 18px;">2&nbsp;</span>
<span style="font-size: 18px;"><strong>Explanation:</strong> 
For position 1: a[1] = 2, range = 1 to 3
For position 2: a[2] = 1, range = 1 to 3
For position 3: a[3] = 1, range = 2 to 4
For position 3: a[4] = 2, range = 2 to 5
For position 3: a[5] = 1, range = 4 to 5
Therefore, the fountain at position a[1] and a[4] covers the whole garden. Therefore, the required output is 2. Also possible answer is a[2] and a[4].</span>
</pre>
<p><strong><span style="font-size: 18px;">Your Task:</span></strong></p>
<p><span style="font-size: 18px;">Your task is to complete the function <strong>minSprinkler()</strong> which takes an integer array <strong>a</strong>&nbsp;and an integer <strong>N</strong> as the input parameters and returns an integer denoting the minimum number of sprinkler needed&nbsp;to be activated such that the whole<strong>&nbsp;N</strong>-length garden can be covered by water.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br><strong>Expected Auxiliary Space:</strong>&nbsp;O(N)</span></p>
<p><strong><span style="font-size: 18px;">Constraints:</span></strong></p>
<ul>
<li><span style="font-size: 18px;">1 &lt;= N &lt;= 2*10<sup>5</sup></span></li>
<li><span style="font-size: 18px;">0 &lt;= arr[i] &lt;= 10<sup>9</sup></span></li>
</ul></div>