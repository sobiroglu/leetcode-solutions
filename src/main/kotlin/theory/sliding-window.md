### Sliding Window Strategy

Sliding Window Technique is a powerful problem-solving approach commonly used when dealing with arrays or strings.

It provides an efficient way to find a specific subset - like a subarray or substring - that satisfies certain conditions criteria within the given input.

Instead of examining every possible subset individually, the sliding window technique works by operating a window
that slides over the array or string. This window dynamically adjusts its size and position based on the problem's condition and requirements.

### How does it work?

1. Initialize two pointers: One representing the start of the window and the other indicating the end of the window.
2. Expanding the Window: Initially, we set both pointers to the beginning of the input string or array. Then, we move 
the end pointer to the right, gradually expanding the window size.
3. Contracting the Window: We check if the current subset meets the problem’s requirements while expanding the window. 
If it does, we will keep expanding. But if it doesn’t, we move the start pointer to shrink the window.
4. Updating Results: Throughout this process, we keep track of relevant metrics or results based on the problem’s requirements. 
This may involve calculating sums, checking for patterns, or storing pertinent information about the subset within the window.

### 209.Minimum Size Subarray Sum

Let’s demonstrate what is explained with a LeetCode example.

The question
Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a subarray whose 
sum is greater than or equal to `target`. If there is no such subarray, return `0` instead.

```
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
```
#### The Approach

**Start and End Pointers**: We start with two pointers, `start` and `end`, both pointing to the beginning of the array. 
These pointers define a window that initially contains only one element.

**Moving the Window:** We move the end pointer to the right, expanding the window. As we do this, we keep track of the sum of elements within the window.

**Summing the Elements:** We calculate the sum of elements within the window. This sum represents the current subarray we’re considering.

**Checking the Sum:** After moving the end pointer, we check if the sum of elements within the window meets our target.

**Adjusting the Window:** If the sum equals or exceeds the target, a subarray that meets the condition is found.

We are now attempting to reduce the subarray’s length by moving the start pointer to the right. This effectively shrinks the window from the left side.

**Recording Lengths:** As we find subarrays meeting the target, we record their lengths. We keep track of all the lengths of such subarrays that we find.

**Finding the Minimal Length:** After exploring all possible subarrays, we look at the lengths we’ve recorded.
We find the smallest length among them and return the result. If we couldn’t find any such subarray, we return 0.

Now that we have a clear plan to solve the problem, we can proceed with coding it.

```js
var minSubArrayLen = function(target, nums) {
    let foundTargetSubarray = [];
    let start = 0;
    let end = 0;
    let sum = 0;

    while (end < nums.length) {
        sum += nums[end];

        while (sum >= target) {
            foundTargetSubarray.push(end - start + 1);
            sum -= nums[start];
            start++;
        }
        end++;
    }
    return  foundTargetSubarray.length < 1 ? 0 : Math.min(...foundTargetSubarray);
};
```

---

### Space and Time Complexity

#### Time Complexity

The function iterates through the `nums` array using a sliding window approach. Each element is visited at **most twice**
overall (once by the end pointer `and` potentially once by the `start` pointer, also Math.min(a,b) function also has a time complexity of O(n)),
leading to a linear time complexity of O(n), where n is the length of the `nums` array.

#### Space Complexity

The main space usage is for the `foundTargetSubarray` array, which holds the lengths of subarrays that meet the target sum.
In the worst-case scenario, this array could hold up to `nums.length` elements if every element in `nums` is part of a subarray that meets the target sum. Therefore, the space complexity is O(n).

---

### What could have been different?

I have shared the first solution that came to my mind while solving this problem but we could change the solution to have less space complexity.

You see, I have used an array `foundTargetSubarray` to keep track of the subarray lengths that meet the target. This causes an additional space complexity of O(n).

Instead of declaring an array, we can use a variable that keeps track of the current minimum subarray length that satisfies our condition.

```js
var minSubArrayLen = function(target, nums) {
    let minSubArrayLength = Infinity;
    let start = 0;
    let end = 0;
    let sum = 0;

    while (end < nums.length) {
        sum += nums[end];

        while (sum >= target) {
            minSubArrayLength = Math.min(minSubArrayLength, end - start + 1);
            sum -= nums[start];
            start++;
        }
        end++;
    }
    // Check if minSubArrayLength is still Infinity, if so, return 0
    return minSubArrayLength === Infinity ? 0 :[sliding-window.md](sliding-window.md) minSubArrayLength;
};
```

With this adjustment, the space complexity is O(1) because the algorithm uses a constant amount of extra space regardless of the input’s size.
* The extra space is used for variables like `minSubArrayLength`, `start`, `end`, and `sum`, but none of these variables grow with the input size. They only store indices or integer values.

---

### Conclusion
Using techniques like the sliding window can greatly enhance the efficiency and clarity of your algorithms. 
It’s a powerful tool that can help solve a variety of problems, particularly those involving arrays or sequences.

However, it’s important to recognize that efficiency isn’t always about finding the perfect solution immediately. 
Sometimes, starting with a simpler approach and gradually refining it can lead to remarkable breakthroughs.

Take the time to immerse yourself in the problem, explore different strategies, and embrace the learning process. 
Each step forward, no matter how small, contributes to your growth as a programmer and deepens your understanding of algorithms and data structures.

So, stay calm, remain focused, and trust in your ability to navigate through challenges. Celebrate your progress, 
no matter how small, and keep moving forward with confidence. As long as you’re committed to learning and improving, you’re on the path to success.

source: https://medium.com/@elfrmkr98/mastering-problem-solving-the-sliding-window-strategy-d38d2ea56427