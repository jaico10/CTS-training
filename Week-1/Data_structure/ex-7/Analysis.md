# Analysis: Financial Forecasting (Recursion)

This document discusses the recursive approach to financial forecasting, its trade-offs, and optimization strategies to avoid execution issues like call stack overflows.

---

## 1. Concept of Recursion

### What is Recursion?
**Recursion** is a programming technique where a method solves a problem by calling itself. Each recursive call represents a smaller subproblem of the original problem.

A recursive method must contain two key elements:
1. **Base Case:** The condition under which the method stops calling itself and returns a value directly. This prevents infinite recursion.
2. **Recursive Step:** The logic that reduces the problem into a smaller subproblem and invokes the method again.

### How Recursion Simplifies Problems
* **Decomposition:** Many problems are naturally defined recursively (e.g., directory structures, tree traversal, math functions like factorials, Fibonacci, and compound interest). Recursion allows the code to align directly with these mathematical definitions.
* **Readability:** Recursive solutions are often cleaner and require fewer lines of code than iterative solutions, as the state is implicitly maintained on the call stack instead of in explicit loops and variables.

---

## 2. Complexity Analysis of the Recursive Algorithm

### Future Value Calculation
The recursive formula is:
$$FV(t) = FV(t - 1) \times (1 + r)$$
with base case:
$$FV(0) = PV$$

### Time Complexity
* **Recursive Method:** $O(t)$, where $t$ is the number of forecasting periods.
  * *Reasoning:* Each call to `calculateFutureValue` decrements the period by 1. For a period of $t$, there will be exactly $t$ recursive calls, making the growth rate linear with respect to the input size.

### Space Complexity
* **Recursive Method:** $O(t)$ auxiliary space.
  * *Reasoning:* Each recursive call allocates a new frame on the JVM call stack. If there are $t$ periods, there will be $t$ frames on the call stack at the deepest point of recursion.
  * *Risk:* For very large periods (e.g., $t \ge 10,000$), this can easily exhaust the stack memory, throwing a `java.lang.StackOverflowError`.

---

## 3. Optimizing the Recursive Solution

To avoid excessive call stack consumption ($O(t)$ space complexity) and protect against `StackOverflowError`, we can apply several optimization techniques:

### A. Iterative Optimization (Looping)
Converting recursion into an iterative loop eliminates the call stack overhead entirely:
* **Time Complexity:** $O(t)$
* **Space Complexity:** $O(1)$ (no new stack frames are created)

### B. Memoization / Dynamic Programming
If the recursive function contains **overlapping subproblems** (e.g., multiple branches predicting different growth rates), caching previously computed values (using a Map or Array) ensures that each unique subproblem is computed exactly once:
* **Time Complexity:** Reduced from exponential $O(2^t)$ to linear $O(t)$ for branching algorithms.
* **Space Complexity:** $O(t)$ for storing the cache.

### C. Tail Call Optimization (TCO)
In languages that support TCO, a recursive call that is the *final operation* in the function can be optimized by the compiler to reuse the current stack frame.
* *Note:* Standard Java Virtual Machines (JVMs) do **not** currently support tail call optimization. Therefore, recursion in Java always consumes stack space, making iterative loops the preferred optimization.
