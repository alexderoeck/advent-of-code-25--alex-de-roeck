<h1 align="center">ADVENT OF CODE 2025</h1>
<h3 align="center">Java - IntelliJ IDEA - Alex de Roeck</h3>
<br>
<br>
<h2>DAY 01 --- Part 1 Completed in 1:52:23</h2>
This day took a long time to complete as I had to teach myself how to read files in Java and refresh myself on Java ArrayLists.
<br><br>
<h3>Links / Websites used to refresh / learn Java:</h3>
<details>
<summary>Links / Purposes</summary>

| Purpose | Link |
|-----:|-----------|
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
    Create a text file containing the Input, and learn how to read text files in Java (as I had not yet learnt how to). <br><br>
  I ended up deciding to learn how to read text files in Java and went with the second option. <br><br>

- Another issue I had after I had written my code, was that my answer was "too low": <br>
  After debugging my code by adding outputs throughout the calculations, I noticed that I hadn't accounted for changes over +/- 99, I fixed this by adding in a while loop to ensure the degrees stayed within the boundary of 0-99.
