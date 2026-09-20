# LeetCode 27 - Remove Element

## Problem

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place.

The order of the remaining elements may be changed.

Return the number of elements in `nums` that are not equal to `val`.

## Example

### Input

```text
nums = [3,2,2,3]
val = 3
```

### Output

```text
2
```

### Explanation

Remove all occurrences of `3`.

The first `k = 2` elements become:

```text
[2,2]
```

The elements after the first `k` positions do not matter.

---

## Approach

We use the **Two Pointer / Write Pointer** approach.

We use two variables:

- `i` → Read/Scan pointer
- `k` → Write/Place pointer

The pointer `i` scans every element of the array.

The pointer `k` tells us where the next valid element should be placed.

If:

```java
nums[i] != val
```

the element should remain in the array.

So we copy it to position `k`:

```java
nums[k] = nums[i];
```

Then increase `k`:

```java
k++;
```

If:

```java
nums[i] == val
```

we simply skip that element.

At the end, `k` represents the number of elements that are not equal to `val`.

---

## Algorithm

1. Initialize `k = 0`.
2. Traverse the array using `i` from `0` to `nums.length - 1`.
3. Check whether `nums[i] != val`.
4. If true:
   - Copy `nums[i]` to `nums[k]`.
   - Increment `k`.
5. If false, skip the element.
6. Return `k`.

---

## Java Code

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
```

---

## Dry Run

Consider:

```text
nums = [3,2,2,3]
val = 3
```

Initially:

```text
k = 0
```

### Iteration 1

```text
i = 0
nums[i] = 3
```

Check:

```text
3 != 3
```

False.

So we skip the element.

```text
k = 0
```

### Iteration 2

```text
i = 1
nums[i] = 2
```

Check:

```text
2 != 3
```

True.

Copy:

```text
nums[k] = nums[i]
nums[0] = nums[1]
```

Array becomes:

```text
[2,2,2,3]
```

Then:

```text
k = 1
```

### Iteration 3

```text
i = 2
nums[i] = 2
```

Check:

```text
2 != 3
```

True.

Copy:

```text
nums[1] = nums[2]
```

Array remains:

```text
[2,2,2,3]
```

Then:

```text
k = 2
```

### Iteration 4

```text
i = 3
nums[i] = 3
```

Check:

```text
3 != 3
```

False.

So we skip it.

```text
k = 2
```

---

## Dry Run Table

| i | nums[i] | nums[i] != val | Action | k |
|---|---|---|---|---|
| 0 | 3 | False | Skip | 0 |
| 1 | 2 | True | `nums[0] = nums[1]` | 1 |
| 2 | 2 | True | `nums[1] = nums[2]` | 2 |
| 3 | 3 | False | Skip | 2 |

---

## Final Result

```text
k = 2
```

The first `k` elements are:

```text
[2,2]
```

Therefore:

```text
return 2
```

---

## Logic in Simple Words

Remember:

```text
i = Reader
k = Writer
```

`i` scans the entire array.

`k` places valid elements at the beginning.

Whenever:

```java
nums[i] != val
```

we do:

```java
nums[k] = nums[i];
k++;
```

Finally:

```java
return k;
```

returns the number of valid elements.

---

## Flowchart

```text
              START
                |
                v
          k = 0, i = 0
                |
                v
        +----------------+
        |    i < n ?     |
        +----------------+
           |          |
          YES         NO
           |           |
           v           v
   +----------------+  RETURN k
   | nums[i] != val?|
   +----------------+
       |          |
      YES         NO
       |           |
       v           |
 nums[k] = nums[i] |
       |           |
       v           |
      k++          |
       |           |
       +-----+-----+
             |
             v
            i++
             |
             v
        Check i < n
```

---

## Complexity Analysis

### Time Complexity

The array is traversed only once.

```text
O(n)
```

### Space Complexity

No extra array or data structure is used.

```text
O(1)
```

Therefore:

```text
Time Complexity  = O(n)
Space Complexity = O(1)
```

---

## Key Takeaway

The most important idea is:

```text
i = Read / Scan
k = Write / Place
```

`i` searches for elements that should stay.

`k` places those elements at the front of the array.

Whenever the current element is not equal to `val`:

```java
nums[k] = nums[i];
k++;
```

At the end:

```java
return k;
```

The first `k` positions contain all elements that are not equal to `val`.