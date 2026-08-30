<h3 align="center">Java - IntelliJ IDEA - Alex de Roeck</h3>

<h1 align="center">ADVENT OF CODE 2025: Days 1-3</h1>

<p align="center">
  <b>Completion Time:</b> 59 minutes and 26 seconds &nbsp;|&nbsp; 
  <b>Constraint:</b> 2-Hour Limit &nbsp;|&nbsp; 
  <b>Success Rate:</b> 100% First-Try Pass
</p>

<blockquote>
  <strong>Result Summary:</strong> Every algorithm was strictly tested and verified against sample text files before executing production puzzle inputs, achieving a flawless first-try success rate across all tasks under pressure.
</blockquote>

<hr>

<h2>Development Workflow and Strategy</h2>

<ul>
  <li><b>Environment:</b> IntelliJ IDEA, Java (Utilising compact source files / implicitly declared classes).</li>
  <li><b>Testing Methodology:</b> Verified against sample test files locally before running production puzzle data.</li>
  <li><b>Data Safety:</b> Deployed <code>long</code> data types to prevent integer overflow when computing massive ID sums and joltage totals.</li>
</ul>

<hr>

<br>
<h2>Task 1: The Safe Dial</h2>

<h3>Part 1: Tracking Final Positions</h3>
<p><b>Objective:</b> Read rotation commands (<code>L</code> for left/anticlockwise, <code>R</code> for right/clockwise), update dial position (starting at 50, wrapping around 0 to 99), and count times the dial pointed at <code>0</code> at the end of a command.</p>
<p><b>Key Logic:</b> Utilised Java's modulo operator (<code>%</code>) with offset additions to cleanly manage wrap-arounds.</p>

<pre><code>// Clockwise: (currentPosition + amount) % 100
// Anticlockwise: (currentPosition - (amount % 100) + 100) % 100</code></pre>

<h3>Part 2: Tracking Every Single Click</h3>
<p><b>Objective:</b> Updated requirement to count <code>0</code> every single time a click of the dial points at it, whether mid-command or at completion.</p>
<p><b>Key Logic:</b> Replaced single-jump math with a nested simulation loop to evaluate every click individually.</p>

<pre><code>for (int i = 0; i &lt; amount; i++) {
    // Simulated click-by-click movement
}</code></pre>

<hr>

<br>
<h2>Task 2: Invalid IDs</h2>

<h3>Part 1: Repeated Halves</h3>
<p><b>Objective:</b> Read comma-separated ID ranges, find IDs made of a sequence repeated twice, and calculate the total sum of all invalid IDs.</p>
<p><b>Key Logic:</b></p>
<ul>
  <li>Parsed ranges via <code>.split(",")</code> and <code>.split("-")</code>.</li>
  <li>Employed <code>long</code> to protect against data overflow.</li>
  <li>Checked even string lengths, split down the middle, and evaluated equality with <code>.equals()</code>.</li>
</ul>

<h3>Part 2: Multi-Repeat Sequences and Regular Expressions</h3>
<p><b>Objective:</b> Expand rules so an ID is invalid if made of a sequence repeating <em>at least</em> twice.</p>
<p><b>Key Logic:</b> Refactored checks using Regular Expressions for high efficiency and clean architecture.</p>

<pre><code>// Regex pattern matching any sequence repeating 1 or more times
Pattern repeatingPattern = Pattern.compile("^(.+)\\1+$");</code></pre>

<hr>

<br>
<h2>Task 3: Elevator Batteries</h2>

<h3>Part 1: Two-Battery Maximum Joltage</h3>
<p><b>Objective:</b> Read rows of battery banks (digits 1-9), turn on exactly two batteries per row without changing order to form the highest two-digit number, and sum total outputs.</p>
<p><b>Key Logic:</b></p>
<ul>
  <li>Nested loops ensuring the second battery sits strictly right of the first.</li>
  <li>Flow control (<code>continue</code>) to skip malformed lines.</li>
  <li>Modular design via helper method <code>getMaxJoltageForBank</code>.</li>
</ul>

<pre><code>int firstDigit = line.charAt(i) - '0'; // ASCII numeric conversion
int secondDigit = line.charAt(j) - '0';
int currentJoltage = (firstDigit * 10) + secondDigit;</code></pre>

<h3>Part 2: Twelve-Battery Greedy Algorithm</h3>
<p><b>Objective:</b> Scale requirements to turn on exactly twelve batteries per bank, forming the ultimate 12-digit sequence.</p>
<p><b>Key Logic:</b> Constructed a greedy algorithm selecting the maximum available digit dynamically within a shifting window.</p>

<pre><code>// Dynamically calculates the search window boundaries
int searchEndIndex = n - 1 - digitsNeededAfterThis;</code></pre>

<hr>

<br>
<h2>How to Run</h2>
<ol>
  <li>Open <b>IntelliJ IDEA</b>.</li>
  <li>Create a fresh Java project and paste the source files into your <code>src</code> directory.</li>
  <li>Drop your input text files (<code>day01.txt</code>, <code>day02test.txt</code>, <code>day03.txt</code>) and adjust the code variables containing the filepath.</li>
  <li>Execute the program</li>
</ol>

<hr>

<!-- 
=========================================================
MY PREVIOUS README CONTENT GOES BELOW THIS LINE
=========================================================
-->

<br><br><br><br><br>

# [Previous Attempts]

<h3>Files:</h3>
"day01" - This contains code for my first attempt for day01 part 1<br>
"day01attempt2" - This contains code for my second attempt for day01 part 1<br>
"day01part2attempt2" - This contains code for my second attempt for day01 part 2<br>
"day02_P1" - This contains code for day02 part 1<br>
<i>Puzzle Input Files: Please see "textFiles" folder, files ending in ".txt"</i>
<br><br>
In order to run my program, you can open my files in the IntelliJ IDEA IDE. <i>I used version 2026.2.1</i>
<br><br>


<h1>ATTEMPT 1</h1>
I attempted to complete the first 3 days of the Advent of Code 2025 in 2 hours. I did this in Java using IntelliJ IDEA.<br><br>

<h2>DAY 01 --- Part 1 Completed at 1:52:23</h2>
This day took a long time to complete as I had to teach myself how to read files in Java and refresh myself on Java ArrayLists (and Java as a whole). The time I spent doing this I included in the total time.

<h2>DAY 01 --- Part 2 Incomplete at 2:00:00</h2>
I was unable to complete part 2 within the remaining time. Because the code I wrote for part 1 was quite complex (rather than trying the most simple solution), it caused a lot of new issues to check for when I then attempted to tweak the code for part 2.

<br><br>
<h3>Links / Websites used to refresh / learn Java:</h3>
<details>
<summary>Links / Purposes</summary>

| Purpose | Link |
|-----|-----------|
| User Input - W3Schools | https://www.w3schools.com/java/java_user_input.asp    |
| User Input - Stack Overflow | https://stackoverflow.com/questions/5287538/how-to-get-the-user-input-in-java    |
| Reading Files - W3Schools | https://www.w3schools.com/java/java_files_read.asp         |
| Scanner - W3Schools | https://www.w3schools.com/java/java_ref_scanner.asp |
| Reading Files - YouTube | https://www.youtube.com/watch?v=eHjbvgw4hsI |
| Buffered Reader - W3Schools | https://www.w3schools.com/java/java_bufferedreader.asp |
| ArrayLists - W3Schools | https://www.w3schools.com/java/java_ref_arraylist.asp |
| ArrayLists foreach() - W3Schools | https://www.w3schools.com/java/ref_arraylist_foreach.asp |
| Comparing two chars - Stack Overflow | https://stackoverflow.com/questions/63342254/how-can-i-compare-two-chars |
| Java Strings - W3Schools | https://www.w3schools.com/java/java_strings.asp |
| Converting char to int - Stack Overflow | https://stackoverflow.com/questions/46343616/how-can-i-convert-a-char-to-int-in-java |

</details>

<br>
<h3>Issues:</h3>

- The biggest issue I had originally was trying to find a way of inputting the Input for Day 01. <br>
  After researching and thinking of ideas, I decided I would either: <br><br>
    Copy and paste the whole Input in and format it with parentheses to be easily be input into an ArrayList. <br>
    <i>OR</i> <br>
    Create a text file containing the Puzzle Input, and learn how to read text files in Java (as I had not yet learnt how to). <br><br>
  I ended up deciding to learn how to read text files in Java, as this would be a useful skill for me to learn, and went with the second option. <br><br>

- Another issue I had after I had written my code, was that my answer was "too low": <br>
  After debugging my code by adding outputs throughout the calculations, I noticed that I hadn't accounted for changes over +/- 99, I fixed this by adding in a while loop to ensure the degrees stayed within the boundary of 0-99.

<br><br>

<h1>ATTEMPT 2</h1>
I reattempted to complete the first 3 days of the Advent of Code 2025 in 2 hours, as during the first attempt I had to learn certain things in Java that I had not learnt yet (and had to generally refresh myself on coding in the language). I again did this in Java using IntelliJ IDEA.<br><br>
The problem I had in the first attempt was overcomplicating the task. In this reattempt I will try and code the most simple solution as I am under a time restraint, rather than trying to write a more efficient code.<br><br>
<b>In this attempt I will pause the timer if I need to research Java that I am unfamiliar with.</b><br><br>

<h2>DAY 01 --- Part 1 Completed at 18:46</h2>
Successfully coded a simplistic solution. I found this considerably easier to code and was able to do it quite quickly. Another reason this was so quick was that I was already familiar with the task and refreshed on coding in Java.

<h2>DAY 01 --- Part 2 Completed at 20:33</h2>
Successfully adjusted my simplistic solution to part 1 in order to solve this part. As my program was very simplistic, it made it extremely easy to tweak it.

<h2>DAY 02 --- Part 1 Incomplete at 2:00:00</h2>
I was unable to finish part 1 of day 2 within the time limit. I attempted to use string manipulation in order to do this task, and although the program works for the Test Input, it does not work with my Puzzle Input.<br><br>
After my time ran out, I looked into how other people approached the puzzle and saw that using Regular Expressions would have made my program a lot simpler to code. I was not aware of Regular Expressions before I looked into this. If I were to attempt this again, I would first learn how to use Regular Expressions in Java before I attempted the puzzle.

<br><br>
<h3>Links / Websites used to refresh / learn Java:</h3>
For attempt 2, I used the below websites to remind myself on certain Java code:
<details>
<summary>Links / Purposes</summary>

| Purpose | Link |
|-----|-----------|
| Java substring() - W3Schools | https://www.w3schools.com/java/ref_string_substring.asp    |
| Java string methods - W3Schools | https://www.w3schools.com/java/java_ref_string.asp    |
| Converting a string to an int - Stack Overflow | https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java        |
| Scanner methods - W3Schools | https://www.w3schools.com/java/java_ref_scanner.asp |
| Reading Files - YouTube | https://www.youtube.com/watch?v=eHjbvgw4hsI |
| Buffered Reader - W3Schools | https://www.w3schools.com/java/java_bufferedreader.asp |
| Converting an int to a string - Stack Overflow | https://stackoverflow.com/questions/5071040/java-convert-integer-to-string |
| Java Long data type - W3Schools | https://www.w3schools.com/java/ref_keyword_long.asp |

</details>


<hr>
<p align="center"><em>Used Gemini to assist in coding (for the succesfful attempt taking 59:26) and assist in writing the README</em></p>
