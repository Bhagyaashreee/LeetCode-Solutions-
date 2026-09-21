# Move Zeroes

## Problem

Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.

The operation must be performed **in-place**, without creating another array.

### Example

Input:
`[0,1,0,3,12]`

Output:
`[1,3,12,0,0]`

---

## Logic

Use two pointers:

- `i` → traverses the array and finds non-zero elements.
- `j` → keeps track of the position where the next non-zero element should be placed.

When `nums[i]` is not zero:

1. Store `nums[i]` in a temporary variable.
2. Set `nums[i]` to `0`.
3. Put the stored value at `nums[j]`.
4. Increment `j`.

This moves every non-zero element toward the beginning while turning its old position into `0`.

### Example

For:

`[0,1,0,3,12]`

Initially:

`j = 0`

When `i = 1`:

`nums[i] = 1`

Move `1` to position `j`:

`[1,0,0,3,12]`

Then:

`j = 1`

When `i = 3`:

`nums[i] = 3`

Move `3` to position `j`:

`[1,3,0,0,12]`

Then:

`j = 2`

When `i = 4`:

`nums[i] = 12`

Move `12` to position `j`:

`[1,3,12,0,0]`

Final array:

`[1,3,12,0,0]`

---

## Algorithm

1. Initialize `j = 0`.
2. Traverse the array using `i` from `0` to `nums.length - 1`.
3. If `nums[i]` is not zero:
   - Store `nums[i]` in `temp`.
   - Set `nums[i] = 0`.
   - Set `nums[j] = temp`.
   - Increment `j`.
4. Continue until the entire array is traversed.
5. The array will contain all non-zero elements in their original order followed by all zeros.

---

## Flow of Logic

Start
↓
Initialize `j = 0`
↓
Traverse array using `i`
↓
Is `nums[i] != 0`?
↓
Yes
↓
Store `nums[i]` in `temp`
↓
Set `nums[i] = 0`
↓
Set `nums[j] = temp`
↓
Increment `j`
↓
Move to next `i`
↓
Repeat until `i == nums.length`
↓
Array contains non-zero elements first and zeros at the end
↓
End

---

## Dry Run

Input:

`nums = [0,1,0,3,12]`

| i | nums[i] | j | Action | Array |
|---|---:|---:|---|---|
| 0 | 0 | 0 | Skip | `[0,1,0,3,12]` |
| 1 | 1 | 0 | Move 1 to index 0 | `[1,0,0,3,12]` |
| 2 | 0 | 1 | Skip | `[1,0,0,3,12]` |
| 3 | 3 | 1 | Move 3 to index 1 | `[1,3,0,0,12]` |
| 4 | 12 | 2 | Move 12 to index 2 | `[1,3,12,0,0]` |

Final Output:

`[1,3,12,0,0]`

---

## Time Complexity

**O(n)**

The array is traversed only once.

Where `n` is the length of the array.

---

## Space Complexity

**O(1)**

Only a few variables such as `i`, `j`, and `temp` are used.

No additional array is created.

---

## Key Idea

`i` → searches for non-zero elements.

`j` → tells where the next non-zero element should be placed.

So:

`i = search`

`j = placement`