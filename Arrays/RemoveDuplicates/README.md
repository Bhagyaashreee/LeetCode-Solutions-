# Remove Duplicates from Sorted Array

## Problem

Given a sorted integer array `nums`, remove the duplicates in-place so that each unique element appears only once.

Return the number of unique elements `k`.

The first `k` elements of the array should contain the unique elements.

## Example

### Input

```text
nums = [1, 1, 2, 2, 3]
```

### Output

```text
3
```

### Modified Array

```text
[1, 2, 3, 2, 3]
```

Only the first `k = 3` elements are considered:

```text
[1, 2, 3]
```

---

# Logic

The array is sorted, so duplicate elements are always next to each other.

We use the Two Pointer Technique.

- `i` is the pointer that scans the array.
- `k` is the pointer that stores the next unique element.

The first element is automatically unique, so we start with:

```text
k = 1
```

Then we start checking from:

```text
i = 1
```

For every element, compare it with the previous element.

```java
nums[i] != nums[i - 1]
```

If they are different, we found a new unique element.

We copy it to position `k`:

```java
nums[k] = nums[i];
```

Then increase `k`:

```java
k++;
```

If they are the same, the element is a duplicate, so we ignore it.

### Easy Way to Remember

```text
i → FIND
k → PLACE
```

---

# Logic Flowchart

```text
             Sorted Array
                  ↓
          First element unique
                  ↓
              k = 1
                  ↓
         Start i from 1
                  ↓
     Compare nums[i] and nums[i-1]
                  ↓
          Are they different?
             /          \
           NO            YES
           ↓              ↓
       Duplicate      New Unique
           ↓              ↓
         Ignore      nums[k] = nums[i]
                          ↓
                        k++
                          ↓
                        i++
                          ↓
                   Continue Loop
                          ↓
                     Return k
```

---

# Algorithm

1. Start with `k = 1` because the first element is always unique.
2. Start a loop from `i = 1` to `n - 1`.
3. Compare `nums[i]` with `nums[i - 1]`.
4. If `nums[i]` is different from `nums[i - 1]`:
   - Copy `nums[i]` to `nums[k]`.
   - Increment `k`.
5. If they are the same, ignore the element because it is a duplicate.
6. Continue until the end of the array.
7. Return `k`.
8. The first `k` elements contain the unique elements.

---

# Dry Run

Consider:

```text
nums = [1, 1, 2, 2, 3]
```

Initially:

```text
k = 1
```

The first element `1` is already unique.

## Iteration 1

```text
i = 1

nums[i]   = 1
nums[i-1] = 1
```

Comparison:

```text
1 != 1 → FALSE
```

They are the same, so `1` is a duplicate.

Ignore it.

```text
k = 1
```

Array remains:

```text
[1, 1, 2, 2, 3]
```

---

## Iteration 2

```text
i = 2

nums[i]   = 2
nums[i-1] = 1
```

Comparison:

```text
2 != 1 → TRUE
```

`2` is a new unique element.

Execute:

```java
nums[k] = nums[i];
```

Currently:

```text
k = 1
i = 2
```

Therefore:

```java
nums[1] = nums[2];
```

Array becomes:

```text
[1, 2, 2, 2, 3]
```

Then:

```java
k++;
```

So:

```text
k = 2
```

---

## Iteration 3

```text
i = 3

nums[i]   = 2
nums[i-1] = 2
```

Comparison:

```text
2 != 2 → FALSE
```

They are the same.

So `2` is a duplicate.

Ignore it.

```text
k = 2
```

Array:

```text
[1, 2, 2, 2, 3]
```

---

## Iteration 4

```text
i = 4

nums[i]   = 3
nums[i-1] = 2
```

Comparison:

```text
3 != 2 → TRUE
```

`3` is a new unique element.

Currently:

```text
k = 2
i = 4
```

Execute:

```java
nums[k] = nums[i];
```

Therefore:

```java
nums[2] = nums[4];
```

Array becomes:

```text
[1, 2, 3, 2, 3]
```

Then:

```text
k = 3
```

---

# Dry Run Table

| Step | i | nums[i] | nums[i-1] | Different? | Action | k |
|---|---:|---:|---:|:---:|---|---:|
| Start | - | - | - | - | `k = 1` | 1 |
| 1 | 1 | 1 | 1 | No | Ignore duplicate | 1 |
| 2 | 2 | 2 | 1 | Yes | Store `2` at `nums[1]` | 2 |
| 3 | 3 | 2 | 2 | No | Ignore duplicate | 2 |
| 4 | 4 | 3 | 2 | Yes | Store `3` at `nums[2]` | 3 |

---

# Final Result

After processing:

```text
nums = [1, 2, 3, 2, 3]
```

Only the first `k` elements are important:

```text
[1, 2, 3]
```

Therefore:

```text
k = 3
```

The method returns:

```java
return k;
```

---

# Java Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {

        int k = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {

                nums[k] = nums[i];

                k++;
            }
        }

        return k;
    }
}
```

---

# Complexity

## Time Complexity

```text
O(n)
```

The array is traversed only once.

## Space Complexity

```text
O(1)
```

No extra array is created.

---

# Key Concept

This problem uses the Two Pointer Technique.

```text
i → FIND unique elements
k → PLACE unique elements
```

The main logic is:

```text
Current element
      ↓
Compare with previous element
      ↓
Different?
   /       \
 NO         YES
 ↓           ↓
Ignore    New unique
             ↓
      nums[k] = nums[i]
             ↓
            k++
```

### One-Line Explanation

Since the array is sorted, compare each element with the previous element. If it is different, place it at index `k` and increment `k`. Finally, return `k`, which represents the number of unique elements.