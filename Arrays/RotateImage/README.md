# Rotate Image

## Logic

To rotate an `n x n` matrix by 90 degrees clockwise, use two steps:

1. **Transpose the matrix**
   - Swap `matrix[i][j]` with `matrix[j][i]`.
   - This changes rows into columns.

2. **Reverse every row**
   - Swap the first element with the last element.
   - Then move towards the center.
   - This produces the 90-degree clockwise rotation.

### Example

Original matrix:

    1 2 3
    4 5 6
    7 8 9

After transpose:

    1 4 7
    2 5 8
    3 6 9

After reversing every row:

    7 4 1
    8 5 2
    9 6 3

Final answer:

    7 4 1
    8 5 2
    9 6 3


## Flow

    Start
      ↓
    Read matrix
      ↓
    Find n = matrix.length
      ↓
    Transpose matrix
      ↓
    Swap matrix[i][j] with matrix[j][i]
      ↓
    Reverse every row
      ↓
    Swap matrix[i][j] with matrix[i][n-1-j]
      ↓
    Matrix rotated by 90° clockwise
      ↓
    End


## Algorithm

1. Find the size of the matrix using `n = matrix.length`.
2. Traverse the upper triangle of the matrix.
3. For every `i` and `j`, where `j = i + 1`, swap:
   
       matrix[i][j] ↔ matrix[j][i]

4. This gives the transpose of the matrix.
5. Traverse every row.
6. For each row, traverse only the first half of the elements.
7. Swap:
   
       matrix[i][j] ↔ matrix[i][n-1-j]

8. After reversing all rows, the matrix is rotated 90 degrees clockwise.


## Dry Run

### Input

    1 2 3
    4 5 6
    7 8 9

### Step 1: Transpose

Initial matrix:

    1 2 3
    4 5 6
    7 8 9

#### Swap 1

    i = 0
    j = 1

    matrix[0][1] = 2
    matrix[1][0] = 4

    Swap 2 and 4:

    1 4 3
    2 5 6
    7 8 9

#### Swap 2

    i = 0
    j = 2

    matrix[0][2] = 3
    matrix[2][0] = 7

    Swap 3 and 7:

    1 4 7
    2 5 6
    3 8 9

#### Swap 3

    i = 1
    j = 2

    matrix[1][2] = 6
    matrix[2][1] = 8

    Swap 6 and 8:

    1 4 7
    2 5 8
    3 6 9

### Step 2: Reverse every row

#### Row 0

    1 4 7

Swap:

    1 ↔ 7

Result:

    7 4 1

#### Row 1

    2 5 8

Swap:

    2 ↔ 8

Result:

    8 5 2

#### Row 2

    3 6 9

Swap:

    3 ↔ 9

Result:

    9 6 3

### Final Matrix

    7 4 1
    8 5 2
    9 6 3


## Time Complexity

The matrix is traversed during transpose and row reversal.

Time Complexity:

    O(n²)


## Space Complexity

The rotation is performed in-place.

No extra 2D matrix is created.

Only a temporary variable is used for swapping.

Space Complexity:

    O(1)


## Key Takeaway

The main trick is:

    90° Clockwise Rotation
            =
       Transpose
            +
      Reverse Rows

Transpose:

    matrix[i][j] ↔ matrix[j][i]

Reverse each row:

    matrix[i][j] ↔ matrix[i][n-1-j]