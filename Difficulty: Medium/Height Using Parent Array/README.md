<h2><a href="https://www.geeksforgeeks.org/problems/height-using-parent-array4103/1?page=2&difficulty=Medium&status=unsolved&sortBy=submissions">Height Using Parent Array</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a parent array <strong>arr</strong>[] of a binary tree of <strong>N</strong> nodes. Element at index i in the array arr[] represents the parent of ith node, i.e,&nbsp;<strong>arr[i] = parent(i)</strong>. Find the height of this binary tree.</span><br>
<span style="font-size:18px"><strong>Note:</strong> There will be a node in the array arr[], where <strong>arr[i] = -1</strong>, which means this node is the root of binary tree.</span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong> N = 7
arr = {-1, 0, 0, 1, 1, 3, 5}
<strong>Output:</strong> 5
<strong>Explanation:</strong> Tree formed is:
                    0
                   / \
                  1   2
                 / \
                3   4
               /
              5
             /
            6      Height of the tree= 5</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You do not need to read input or print anything. Your task is to complete the function <strong>findHeight()</strong> which takes N and arr[] as input parameters and returns the height of the given binary tree.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N*N)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>5</sup></span><br>
<span style="font-size:18px">0 ≤ arr[i] ≤ 10</span><sup style="font-size:18px">5</sup><span style="font-size:18px">&nbsp; &nbsp;</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;