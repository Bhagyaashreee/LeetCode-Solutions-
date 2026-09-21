# 36. Valid Sudoku

## Logic

The goal is to check whether a 9 × 9 Sudoku board is valid.

A valid Sudoku must satisfy 3 conditions:

1. No digit `1-9` can repeat in the same row.
2. No digit `1-9` can repeat in the same column.
3. No digit `1-9` can repeat in the same 3 × 3 box.

We use three 2D arrays:

- `rows[9][9]` → stores digits already present in each row.
- `cols[9][9]` → stores digits already present in each column.
- `boxes[9][9]` → stores digits already present in each 3 × 3 box.

For every cell `(r, c)`:

- If the cell contains `.`, skip it.
- Convert the digit into an index from `0-8`.
- Check whether the digit already exists in its row.
- Check whether the digit already exists in its column.
- Find its 3 × 3 box and check whether the digit already exists there.
- If a duplicate is found, return `false`.
- Otherwise, mark the digit as present in the row, column, and box.
- If all cells are checked successfully, return `true`.

## Flow

START
  ↓
Create rows[9][9], cols[9][9], boxes[9][9]
  ↓
Traverse every cell (r, c)
  ↓
Is board[r][c] == '.'?
  ├── YES → Skip the cell
  │
  └── NO
       ↓
   Convert digit to index
       ↓
   Find the 3 × 3 box
       ↓
   Check row, column and box
       ↓
   Duplicate found?
      ├── YES → return false
      │
      └── NO
           ↓
      Mark digit in row,
      column and box
           ↓
      Continue to next cell
           ↓
      All cells checked?
           ↓
      return true

## Algorithm

1. Create three `9 × 9` integer arrays:
   - `rows`
   - `cols`
   - `boxes`

2. Traverse every cell using two loops.

3. If the current cell is `.`, skip it.

4. Convert the character digit into an array index:
   `int val = board[r][c] - '1';`

5. Check whether the digit already exists in the current row:
   `if (rows[r][val] == 1) return false;`

6. Mark the digit in the row:
   `rows[r][val] = 1;`

7. Check whether the digit already exists in the current column:
   `if (cols[c][val] == 1) return false;`

8. Mark the digit in the column:
   `cols[c][val] = 1;`

9. Find the corresponding 3 × 3 box using:
   `int boxIdx = 3 * (r / 3) + (c / 3);`

10. Check whether the digit already exists in the box:
    `if (boxes[boxIdx][val] == 1) return false;`

11. Mark the digit in the box:
    `boxes[boxIdx][val] = 1;`

12. After checking all cells, return `true`.

## Finding the 3 × 3 Box

Formula:

`int boxIdx = 3 * (r / 3) + (c / 3);`

Integer division groups rows and columns into groups of 3.

Rows:
- `0,1,2` → row group `0`
- `3,4,5` → row group `1`
- `6,7,8` → row group `2`

Columns:
- `0,1,2` → column group `0`
- `3,4,5` → column group `1`
- `6,7,8` → column group `2`

Therefore:

`boxIdx = 3 × rowGroup + columnGroup`

Example:

For `r = 4` and `c = 7`:

`boxIdx = 3 * (4 / 3) + (7 / 3)`
`       = 3 * 1 + 2`
`       = 5`

Therefore, cell `(4,7)` belongs to box `5`.

## Dry Run

Suppose:

`board[0][0] = '5'`

Convert the digit:

`val = '5' - '1'`
`    = 4`

Check the row:

`rows[0][4]`

If it is `0`, digit `5` has not appeared in row `0`.

Mark it:

`rows[0][4] = 1`

Check the column:

`cols[0][4]`

If it is `0`, mark it:

`cols[0][4] = 1`

Find the box:

`boxIdx = 3 * (0 / 3) + (0 / 3)`
`       = 0`

Check:

`boxes[0][4]`

If it is `0`, mark it:

`boxes[0][4] = 1`

Then continue to the next cell.

If another `5` appears in the same row, column, or box, the corresponding value will already be `1`, so the algorithm returns `false`.



## Time Complexity

The board contains `9 × 9 = 81` cells.

Each cell is visited exactly once and all operations inside the loop take constant time.

Time Complexity:

`O(9 × 9) = O(81) = O(1)`

For a generalized `n × n` board:

`O(n²)`

## Space Complexity

We use three `9 × 9` arrays:

- `rows` → `9 × 9`
- `cols` → `9 × 9`
- `boxes` → `9 × 9`

Since Sudoku has a fixed board size of `9 × 9`:

Space Complexity:

`O(1)`

For a generalized `n × n` board:

`O(n²)`

## Key Takeaway

The main idea is to track every number simultaneously in its:

- Row
- Column
- 3 × 3 Box

For every filled cell:

`Number → Check Row → Check Column → Check Box`

If the number is already present in any of them:

`return false`

Otherwise, mark it as present and continue.

If every cell is checked without finding a duplicate:

`return true`

### Important Formula

`int boxIdx = 3 * (r / 3) + (c / 3);`

This formula identifies which of the 9 different `3 × 3` boxes contains the current cell.