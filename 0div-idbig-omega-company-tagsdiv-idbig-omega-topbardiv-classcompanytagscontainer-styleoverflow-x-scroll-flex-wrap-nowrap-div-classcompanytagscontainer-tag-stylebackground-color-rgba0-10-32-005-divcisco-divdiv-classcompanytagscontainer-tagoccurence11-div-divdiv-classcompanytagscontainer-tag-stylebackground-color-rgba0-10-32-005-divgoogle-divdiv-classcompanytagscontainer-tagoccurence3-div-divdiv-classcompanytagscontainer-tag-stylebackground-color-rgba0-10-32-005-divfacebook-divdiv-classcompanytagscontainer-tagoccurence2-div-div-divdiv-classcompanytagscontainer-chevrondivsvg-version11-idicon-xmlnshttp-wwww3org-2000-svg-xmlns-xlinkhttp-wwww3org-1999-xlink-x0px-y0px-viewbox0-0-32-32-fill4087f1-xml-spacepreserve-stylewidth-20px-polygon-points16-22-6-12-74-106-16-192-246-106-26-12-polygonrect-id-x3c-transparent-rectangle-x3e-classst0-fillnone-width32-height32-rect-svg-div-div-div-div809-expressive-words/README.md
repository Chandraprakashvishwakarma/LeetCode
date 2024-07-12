<h2><a href="https://leetcode.com/problems/expressive-words/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Cisco</div><div class="companyTagsContainer--tagOccurence">11</div></div><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Google</div><div class="companyTagsContainer--tagOccurence">3</div></div><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Facebook</div><div class="companyTagsContainer--tagOccurence">2</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>809. Expressive Words</a></h2><h3>Medium</h3><hr><div><p>Sometimes people repeat letters to represent extra feeling. For example:</p>

<ul>
	<li><code>"hello" -&gt; "heeellooo"</code></li>
	<li><code>"hi" -&gt; "hiiii"</code></li>
</ul>

<p>In these strings like <code>"heeellooo"</code>, we have groups of adjacent letters that are all the same: <code>"h"</code>, <code>"eee"</code>, <code>"ll"</code>, <code>"ooo"</code>.</p>

<p>You are given a string <code>s</code> and an array of query strings <code>words</code>. A query word is <strong>stretchy</strong> if it can be made to be equal to <code>s</code> by any number of applications of the following extension operation: choose a group consisting of characters <code>c</code>, and add some number of characters <code>c</code> to the group so that the size of the group is <strong>three or more</strong>.</p>

<ul>
	<li>For example, starting with <code>"hello"</code>, we could do an extension on the group <code>"o"</code> to get <code>"hellooo"</code>, but we cannot get <code>"helloo"</code> since the group <code>"oo"</code> has a size less than three. Also, we could do another extension like <code>"ll" -&gt; "lllll"</code> to get <code>"helllllooo"</code>. If <code>s = "helllllooo"</code>, then the query word <code>"hello"</code> would be <strong>stretchy</strong> because of these two extension operations: <code>query = "hello" -&gt; "hellooo" -&gt; "helllllooo" = s</code>.</li>
</ul>

<p>Return <em>the number of query strings that are <strong>stretchy</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "heeellooo", words = ["hello", "hi", "helo"]
<strong>Output:</strong> 1
<strong>Explanation:</strong> 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
	<li><code>s</code> and <code>words[i]</code> consist of lowercase letters.</li>
</ul>
</div>