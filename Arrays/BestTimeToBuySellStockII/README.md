# Best Time to Buy and Sell Stock II

## Logic

We can buy and sell the stock multiple times, but we can hold only one stock at a time.

The main idea is to take every profit that can be made when the current day's price is greater than the previous day's price.

For every pair of consecutive prices:

- If `prices[i] > prices[i-1]`, there is a profit.
- Add `prices[i] - prices[i-1]` to `maxProfit`.
- If the price decreases or stays the same, do nothing.

By adding all positive differences, we get the maximum possible profit.

---

## Flow

Start
↓
Read the `prices` array
↓
Initialize `maxProfit = 0`
↓
Start loop from `i = 1`
↓
Compare `prices[i]` with `prices[i-1]`
↓
Is `prices[i] > prices[i-1]`?
├── Yes → Calculate profit = `prices[i] - prices[i-1]`
│         ↓
│      Add profit to `maxProfit`
│
└── No → Do nothing
↓
Are more elements left?
├── Yes → Continue loop
└── No → Return `maxProfit`
↓
End

---

## Algorithm

1. Initialize `maxProfit = 0`.
2. Start traversing the array from index `1`.
3. Compare the current price with the previous day's price.
4. If the current price is greater:
   - Calculate the profit as `prices[i] - prices[i-1]`.
   - Add this profit to `maxProfit`.
5. If the current price is smaller or equal, skip it.
6. Continue until the end of the array.
7. Return `maxProfit`.

---

## Dry Run

### Input

`prices = [7, 1, 5, 3, 6, 4]`

| i | prices[i-1] | prices[i] | Condition | Profit Added | maxProfit |
|---|-------------|-----------|-----------|--------------|-----------|
| 1 | 7 | 1 | 1 > 7 ❌ | 0 | 0 |
| 2 | 1 | 5 | 5 > 1 ✅ | 5 - 1 = 4 | 4 |
| 3 | 5 | 3 | 3 > 5 ❌ | 0 | 4 |
| 4 | 3 | 6 | 6 > 3 ✅ | 6 - 3 = 3 | 7 |
| 5 | 6 | 4 | 4 > 6 ❌ | 0 | 7 |

### Final Result

`maxProfit = 7`

Profit is:

`(5 - 1) + (6 - 3)`

`= 4 + 3`

`= 7`

So the maximum profit is **7**.

---

## Time Complexity

**O(n)**

We traverse the array once, so the time complexity is O(n).

---

## Space Complexity

**O(1)**

Only the `maxProfit` variable and loop variable are used, so no extra space is required.