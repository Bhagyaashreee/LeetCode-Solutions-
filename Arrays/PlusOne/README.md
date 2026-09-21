# 66. Plus One

## Algorithm

1. Start from the last index of the array:
   `i = digits.length - 1`
2. Traverse the array from right to left.
3. Check if `digits[i] == 9`.
4. If `digits[i] == 9`:
   - Change `digits[i]` to `0`.
   - Move to the previous digit.
5. If `digits[i] != 9`:
   - Increase `digits[i]` by `1`.
   - Return the array immediately.
6. If the loop finishes, all digits were `9`.
7. Create a new array of size `digits.length + 1`.
8. Set `res[0] = 1`.
9. Return `res`.

---

## Flow of Logic

    START
      |
      v
    Start from last index
    i = digits.length - 1
      |
      v
    Is i >= 0?
      |
      +------ NO ------> All digits were 9
      |                       |
     YES                      v
      |                 Create new array
      v                 of size n + 1
    Is digits[i] == 9?       |
      |                      v
      | YES              res[0] = 1
      v                      |
    digits[i] = 0            v
      |                  Return res
      v                      |
    i = i - 1                v
      |                     END
      |
      +-------> Check i >= 0


    If digits[i] != 9:
      |
      v
    digits[i] = digits[i] + 1
      |
      v
    Return digits
      |
      v
     END

---

## Dry Run

### Example 1: [1,2,3]

Input:

    digits = [1,2,3]

Start from the last index:

    i = digits.length - 1
    i = 3 - 1
    i = 2

Current digit:

    digits[2] = 3

Check:

    3 == 9 → NO

So increase the digit by 1:

    digits[2] = 3 + 1
    digits[2] = 4

Array becomes:

    [1,2,4]

Return the array.

Output:

    [1,2,4]

---

### Example 2: [1,2,9]

Input:

    digits = [1,2,9]

Start:

    i = 2
    digits[2] = 9

Check:

    9 == 9 → YES

Change 9 to 0:

    digits[2] = 0

Array:

    [1,2,0]

Move to the previous index:

    i = 1

Current digit:

    digits[1] = 2

Check:

    2 == 9 → NO

Increase it by 1:

    digits[1] = 2 + 1
    digits[1] = 3

Array becomes:

    [1,3,0]

Return the array.

Output:

    [1,3,0]

---

### Example 3: [1,9,9]

Input:

    digits = [1,9,9]

Start:

    i = 2
    digits[2] = 9

Since the digit is 9:

    digits[2] = 0

Array:

    [1,9,0]

Move left:

    i = 1
    digits[1] = 9

Again, the digit is 9:

    digits[1] = 0

Array:

    [1,0,0]

Move left:

    i = 0
    digits[0] = 1

Check:

    1 == 9 → NO

Increase it by 1:

    digits[0] = 1 + 1
    digits[0] = 2

Final array:

    [2,0,0]

Output:

    [2,0,0]

---

### Example 4: [9]

Input:

    digits = [9]

Start:

    i = 0
    digits[0] = 9

Check:

    9 == 9 → YES

Change it to 0:

    digits[0] = 0

Array:

    [0]

Move left:

    i = -1

Check loop condition:

    i >= 0
    -1 >= 0 → NO

The loop finishes.

This means all digits were 9.

Create a new array:

    int[] res = new int[digits.length + 1]

Since:

    digits.length = 1

New array size:

    2

Initially:

    res = [0,0]

Set:

    res[0] = 1

Final result:

    [1,0]

Output:

    [1,0]

---

## Time Complexity

    O(n)

In the worst case, all digits are `9`, so we traverse the entire array.

---

## Space Complexity

    O(1)

For the normal case, the original array is modified directly.

If all digits are `9`, a new array of size `n + 1` is created.

Therefore, the worst-case extra space is:

    O(n)

---

## Key Logic

    Start from the last digit
             |
             v
        Is digit 9?
          /      \
        YES       NO
         |         |
         v         v
      Change 9   Add 1
       to 0        |
         |          v
         v       Return
      Move left
         |
         v
      Continue
         |
         v
    All digits are 9?
         |
         v
    Create [1,0,0,...,0]
         |
         v
       Return