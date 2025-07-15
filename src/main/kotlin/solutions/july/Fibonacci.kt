package solutions

class Fibonacci {
    private val MAX = 100
    private val NOT_FOUND = -1
    private val fibDP = IntArray(MAX) { NOT_FOUND }

    /**
     * Dynamic programming (Top-down/Memoization)
     * Time complexity: O(N)
     */
    fun fib(n: Int): Int {
        if (n < 2) {
            fibDP[n] = n
            return n
        }

        if (fibDP[n] != NOT_FOUND) {
            return fibDP[n]
        }

        fibDP[n] = fib(n - 1) + fib(n - 2)
        return fibDP[n]
    }

    /**
     * Recursive approach
     * Time complexity: O(N^2)
     */
    fun fibonacciRecur(n: Int): Int {
        if (n < 2) {
            return n
        }
        return fibonacciRecur(n - 1) + fibonacciRecur(n - 2)
    }

    /**
     * Dynamic programming (Bottom-up/Tabulation)
     * Time complexity: O(N)
     */
    fun fibonnaciWithTabulation(n: Int): Int {
        val f = IntArray(n + 1)

        f[0] = 0
        f[1] = 1

        for (i in 2..n) {
            f[i] = f[i - 1] + f[i - 2]
        }

        return f[n]
    }
}