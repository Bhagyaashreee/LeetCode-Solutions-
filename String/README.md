# Longest Substring Without Repeating Characters

## LeetCode Problem 3

### Problem

Given a string, find the length of the longest substring that contains no repeating characters.

Example:

```text
Input:  "abcabcbb"
Output: 3
```

The longest substring without repeating characters is:

```text
"abc"
```

---

# Main Logic

We use:

```text
Sliding Window + HashSet
```

The window is represented by two pointers:

```text
left ........ right
```

### What each one does

```text
right → expands the window

left → shrinks the window when a duplicate appears

HashSet → stores characters currently inside the window

max → stores the longest valid window length
```

### Basic idea

1. Move `right` through the string.
2. Add each character to the `HashSet`.
3. If the character is already present, a duplicate exists.
4. Move `left` forward and remove characters until the duplicate disappears.
5. Add the current character.
6. Calculate the current window length:

```text
right - left + 1
```

7. Update `max`.
8. Continue until the end of the string.

---

# Dry Run

Consider:

```text
s = "abcabcbb"
```

Indexes:

```text
Index:  0 1 2 3 4 5 6 7
Char:   a b c a b c b b
```

---

## Step 1

```text
right = 0
character = a
```

Set:

```text
{a}
```

Window:

```text
[a]
```

Length:

```text
1
```

Maximum:

```text
max = 1
```

---

## Step 2

```text
right = 1
character = b
```

`b` is not in the set.

Set:

```text
{a,b}
```

Window:

```text
[ab]
```

Length:

```text
2
```

Maximum:

```text
max = 2
```

---

## Step 3

```text
right = 2
character = c
```

`c` is not in the set.

Set:

```text
{a,b,c}
```

Window:

```text
[abc]
```

Length:

```text
3
```

Maximum:

```text
max = 3
```

---

## Step 4

```text
right = 3
character = a
```

`a` is already in the set.

So we have a duplicate.

Current window:

```text
[abc]a
 ↑   ↑
left right
```

Remove the character at `left`:

```text
remove a
```

Move `left` forward:

```text
left = 1
```

Now:

```text
{b,c}
```

Add the new `a`:

```text
{b,c,a}
```

Window:

```text
[bca]
```

Length:

```text
3
```

Maximum:

```text
max = 3
```

---

## Step 5

```text
right = 4
character = b
```

`b` is already present.

Remove the old `b`.

Move `left` forward.

Window becomes:

```text
[cab]
```

Set:

```text
{c,a,b}
```

Length:

```text
3
```

Maximum:

```text
3
```

---

## Step 6

```text
right = 5
character = c
```

`c` is already present.

Remove the old `c`.

Move `left` forward.

Window becomes:

```text
[abc]
```

Length:

```text
3
```

Maximum:

```text
3
```

---

## Step 7

```text
right = 6
character = b
```

Current window:

```text
[abc]b
```

`b` is a duplicate.

We start removing from the left.

First remove:

```text
a
```

Move `left`.

But `b` is still present.

So remove:

```text
b
```

Move `left` again.

Now the window becomes:

```text
[cb]
```

Set:

```text
{c,b}
```

Length:

```text
2
```

Maximum remains:

```text
3
```

### Important

This step shows why we use a `while` condition.

Sometimes we need to remove **more than one character** before the duplicate disappears.

---

## Step 8

```text
right = 7
character = b
```

`b` is already present.

Remove characters from the left until `b` is no longer present.

Remove:

```text
c
```

Then remove:

```text
b
```

Now:

```text
{b}
```

Window:

```text
[b]
```

Length:

```text
1
```

Maximum remains:

```text
3
```

---

# Dry Run Table

| Step | Right | Character | Left | Window | Length | Max |
|------|------:|-----------|-----:|--------|-------:|----:|
| 1 | 0 | a | 0 | `a` | 1 | 1 |
| 2 | 1 | b | 0 | `ab` | 2 | 2 |
| 3 | 2 | c | 0 | `abc` | 3 | 3 |
| 4 | 3 | a | 1 | `bca` | 3 | 3 |
| 5 | 4 | b | 2 | `cab` | 3 | 3 |
| 6 | 5 | c | 3 | `abc` | 3 | 3 |
| 7 | 6 | b | 5 | `cb` | 2 | 3 |
| 8 | 7 | b | 7 | `b` | 1 | 3 |

Final answer:

```text
3
```

---

# Sliding Window Visualization

For:

```text
abcabcbb
```

The window grows:

```text
[a]
```

```text
[ab]
```

```text
[abc]
```

A duplicate `a` appears:

```text
[abc]a
```

Remove from the left:

```text
a[bc]a
```

After removing the old `a`:

```text
[bca]
```

Then:

```text
[cab]
```

Then:

```text
[abc]
```

When another `b` appears:

```text
[abc]b
```

Remove from the left until `b` is no longer duplicated:

```text
[cb]
```

Finally:

```text
[b]
```

Throughout the process, the window always contains **unique characters**.

---

# Flowchart

```text
              START
                |
                v
        left = 0, max = 0
                |
                v
       Move right pointer
                |
                v
       Get current character
                |
                v
      Is character in HashSet?
           /             \
         YES              NO
          |                |
          v                |
   Remove character        |
      from left            |
          |                |
          v                |
       left++              |
          |                |
          +------<---------+
                |
                v
      Check duplicate again
                |
                v
          No duplicate
                |
                v
      Add character to set
                |
                v
   Calculate window length
      right - left + 1
                |
                v
          Update max
                |
                v
       More characters?
          /          \
        YES           NO
         |             |
         v             v
       Repeat      Return max
```

---

# Key Points to Remember

### 1. `right` expands

```text
right → moves forward
```

It explores new characters.

### 2. `left` shrinks

```text
left → moves forward when duplicate appears
```

It removes unwanted characters.

### 3. HashSet checks duplicates

```text
HashSet → tells whether character already exists
```

### 4. Window must always be unique

At any point:

```text
window = substring with no duplicate characters
```

### 5. Window length

```text
right - left + 1
```

### 6. `max`

```text
max → longest valid window found so far
```

### 7. Why `while`?

Because sometimes more than one character must be removed.

```text
Duplicate
   ↓
Remove from left
   ↓
Still duplicate?
   ↓
YES → Remove again
   ↓
NO → Continue
```

---

# Pattern to Remember

When you see:

```text
Longest substring
+
No repeating characters
```

Immediately think:

```text
Sliding Window
        +
HashSet
```

General pattern:

```text
Move right
    ↓
Check condition
    ↓
Condition violated?
    ↓
Move left until valid
    ↓
Calculate window size
    ↓
Update answer
    ↓
Repeat
```

---

# Complexity

### Time Complexity

```text
O(n)
```

Each character is added and removed at most once.

### Space Complexity

```text
O(n)
```

The HashSet stores the characters in the current window.

---

# Final Logic in One Line

```text
Expand with RIGHT → remove duplicates using LEFT → keep unique window → calculate length → update MAX
```

---

# Most Important Things to Memorize

```text
RIGHT = EXPAND
LEFT  = SHRINK
SET   = CHECK DUPLICATES
MAX   = STORE ANSWER

WINDOW LENGTH = right - left + 1
```

For:

```text
"abcabcbb"
```

the longest substring without repeating characters is:

```text
"abc"
```

Therefore:

```text
Answer = 3
```