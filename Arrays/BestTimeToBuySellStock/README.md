# Best Time to Buy and Sell Stock

## Logic

We need to find the maximum profit by:
- Buying the stock at the lowest price seen so far.
- Selling it later at the highest possible price.

We maintain two variables:

- `minPrice` → stores the minimum stock price seen so far.
- `maxProfit` → stores the maximum profit found so far.

For every price:
1. If the current price is smaller than `minPrice`, update `minPrice`.
2. Calculate the profit using:
   `profit = price - minPrice`
3. If this profit is greater than `maxProfit`, update `maxProfit`.
4. Continue until the entire array is checked.

This guarantees that the buying day always comes before the selling day.

---

## Flow

Start
↓
Read the `prices` array
↓
Set `minPrice = Integer.MAX_VALUE`
↓
Set `maxProfit = 0`
↓
Traverse each price
↓
Is `price < minPrice`?
├── Yes → Update `minPrice = price`
└── No → Keep `minPrice`
↓
Calculate `profit = price - minPrice`
↓
Is `profit > maxProfit`?
├── Yes → Update `maxProfit = profit`
└── No → Keep `maxProfit`
↓
Are there more prices?
├── Yes → Continue loop
└── No → Return `maxProfit`
↓
End

---

## Algorithm

1. Initialize `minPrice` to `Integer.MAX_VALUE`.
2. Initialize `maxProfit` to `0`.
3. Traverse the `prices` array using a loop.
4. For every price:
   - If the price is less than `minPrice`, update `minPrice`.
   - Calculate the current profit as `price - minPrice`.
   - If the current profit is greater than `maxProfit`, update `maxProfit`.
5. After traversing the array, return `maxProfit`.

---

## Dry Run

### Input

`prices = [7, 1, 5, 3, 6, 4]`

| Step | Price | minPrice | Profit = price - minPrice | maxProfit |
|------|-------|----------|----------------------------|-----------|
| 1 | 7 | 7 | 0 | 0 |
| 2 | 1 | 1 | 0 | 0 |
| 3 | 5 | 1 | 4 | 4 |
| 4 | 3 | 1 | 2 | 4 |
| 5 | 6 | 1 | 5 | 5 |
| 6 | 4 | 1 | 3 | 5 |

### Explanation

- Price `7` → first price, so `minPrice = 7`, profit = `0`.
- Price `1` → smaller than `7`, so `minPrice = 1`.
- Price `5` → profit = `5 - 1 = 4`, so `maxProfit = 4`.
- Price `3` → profit = `3 - 1 = 2`, so `maxProfit` remains `4`.
- Price `6` → profit = `6 - 1 = 5`, so `maxProfit = 5`.
- Price `4` → profit = `4 - 1 = 3`, so `maxProfit` remains `5`.

Therefore:

**Maximum Profit = 5**

Buy at price `1` and sell at price `6`.

---

## Time Complexity

**O(n)**

We traverse the array only once.

---

## Space Complexity

**O(1)**

Only `minPrice`, `maxProfit`, and a few temporary variables are used.