# LeetCode 2 - Add Two Numbers

## Problem

You are given two linked lists that represent two numbers.

The digits are stored in reverse order.

Add the two numbers and return the result as a linked list.

### Example

```text
l1 = 2 → 4 → 3
l2 = 5 → 6 → 4

342 + 465 = 807

Answer:
7 → 0 → 8
```

---

## Logic

```text
l1 and l2
    ↓
Get current digits
    ↓
x + y + carry
    ↓
   sum
  ↙   ↘
sum % 10   sum / 10
   ↓          ↓
 digit       carry
   ↓
Create new node
   ↓
Move current
   ↓
Move l1 and l2
   ↓
 Repeat
   ↓
Return dummy.next
```

---

## Important Variables

### 1. dummy

```text
dummy → 0
```

`dummy` is a temporary starting node.

It makes it easier to build the result linked list.

The actual answer starts from:

```text
dummy.next
```

---

### 2. current

`current` points to the last node of the result.

Initially:

```text
dummy → 0
         ↑
      current
```

When we create a new node:

```java
current.next = new ListNode(digit);
```

The new node is attached to the result.

Then:

```java
current = current.next;
```

moves `current` to the newly created node.

---

### 3. carry

`carry` stores the extra value when the sum is 10 or more.

Example:

```text
4 + 6 = 10

digit = 10 % 10 = 0
carry = 10 / 10 = 1
```

The `0` becomes the current digit and `1` is carried to the next round.

---

### 4. x and y

`x` stores the current digit from `l1`.

`y` stores the current digit from `l2`.

```java
x = l1.val;
y = l2.val;
```

If one linked list has already ended, its value remains `0`.

---

# Dry Run

## Input

```text
l1 = 2 → 4 → 3
l2 = 5 → 6 → 4
```

These represent:

```text
342 + 465
```

---

## Round 1

Current values:

```text
l1 = 2
l2 = 5
carry = 0
```

Calculate:

```text
sum = x + y + carry

sum = 2 + 5 + 0

sum = 7
```

Get digit:

```text
digit = sum % 10

digit = 7 % 10

digit = 7
```

Get carry:

```text
carry = sum / 10

carry = 7 / 10

carry = 0
```

Create node:

```text
dummy → 7
          ↑
       current
```

Move the linked lists:

```text
l1 → 4 → 3
l2 → 6 → 4
```

---

## Round 2

Current values:

```text
l1 = 4
l2 = 6
carry = 0
```

Calculate:

```text
sum = 4 + 6 + 0

sum = 10
```

Get digit:

```text
digit = 10 % 10

digit = 0
```

Get carry:

```text
carry = 10 / 10

carry = 1
```

Create node:

```text
dummy → 7 → 0
              ↑
           current
```

Move the linked lists:

```text
l1 → 3
l2 → 4
```

---

## Round 3

Current values:

```text
l1 = 3
l2 = 4
carry = 1
```

Calculate:

```text
sum = 3 + 4 + 1

sum = 8
```

Get digit:

```text
digit = 8 % 10

digit = 8
```

Get carry:

```text
carry = 8 / 10

carry = 0
```

Create node:

```text
dummy → 7 → 0 → 8
```

---

# Final Result

```text
7 → 0 → 8
```

Therefore:

```text
342 + 465 = 807
```

---

# Why do we use `% 10`?

```java
digit = sum % 10;
```

`% 10` gives the last digit of the number.

Examples:

```text
17 % 10 = 7
25 % 10 = 5
10 % 10 = 0
8 % 10 = 8
```

So it gives the digit that should be stored in the current node.

---

# Why do we use `/ 10`?

```java
carry = sum / 10;
```

Integer division by 10 gives the carry.

Examples:

```text
17 / 10 = 1
25 / 10 = 2
10 / 10 = 1
8 / 10 = 0
```

---

# Why is the loop condition like this?

```java
while (l1 != null || l2 != null || carry != 0)
```

We continue while:

1. `l1` still has a node, OR
2. `l2` still has a node, OR
3. there is still a `carry`.

This is important because there may be a carry left after both lists end.

Example:

```text
l1 = 9
l2 = 1

9 + 1 = 10
```

Result:

```text
0 → 1
```

The loop must run one extra time to store the final carry `1`.

---

# Step-by-Step Flow

```text
Start
  ↓
Take current node from l1
  ↓
Take current node from l2
  ↓
Add x + y + carry
  ↓
Calculate digit = sum % 10
  ↓
Calculate carry = sum / 10
  ↓
Create new node with digit
  ↓
Attach node to result
  ↓
Move current
  ↓
Move l1 and l2
  ↓
Are l1, l2 or carry remaining?
  ↓
 Yes ─────────→ Repeat
  ↓
 No
  ↓
Return dummy.next
  ↓
End
```

---

# Time Complexity

```text
O(max(n, m))
```

We go through each node of the two linked lists once.

Where:

- `n` = length of `l1`
- `m` = length of `l2`

---

# Space Complexity

```text
O(max(n, m))
```

We create a new linked list to store the answer.

---

# Key Takeaway

The main idea is:

```text
Take digits
    ↓
Add digits + carry
    ↓
Get digit using % 10
    ↓
Get carry using / 10
    ↓
Create a new node
    ↓
Move to next nodes
    ↓
Repeat
    ↓
Return dummy.next
```

This is the basic pattern for adding numbers represented using linked lists.