package com.sobiroglu.solutions.july

class Solution0395 {
    fun longestSubstring(s: String, k: Int): Int {
        var leftIndicator = 0
        var rightIndicator = 0
        var map = HashMap<Char, Int>()
        var result = 0
        val uniqueCharsCount = getUniqueCharsCount(s)

        for (i in 1..uniqueCharsCount) {
            while (rightIndicator < s.length || map.keys.size > i) {
                if (map.keys.size > i) {
                    if (map.containsKey(s[leftIndicator])) {
                        map.decrementOrRemove(s[leftIndicator])
                    }

                    leftIndicator++
                    continue
                }

                map.incrementOrAdd(s[rightIndicator])
                rightIndicator++

                if (map.values.all { it >= k}) {
                    if (rightIndicator - leftIndicator > result) {
                        result = rightIndicator - leftIndicator
                    }
                }
            }

            leftIndicator = 0
            rightIndicator = 0
            map = HashMap()
        }
        return result
    }

    //map.put(s[leftIndicator], (map[s[leftIndicator]] ?: 0) - 1)
    fun HashMap<Char, Int>.decrementOrRemove(c: Char) {
        this[c]?.let {
            if (it > 1) this[c] = it - 1 else this.remove(c)
        }
    }

    //map.put(s[rightIndicator], (map[s[rightIndicator]] ?: 0) + 1)
    fun HashMap<Char, Int>.incrementOrAdd(c: Char) {
        this[c].let {
            if (it != null) this[c] = it + 1 else this[c] = 1
        }
    }

    // getUniqueCharsCount
    fun getUniqueCharsCount(s: String): Int {
        var counter = 0
        val array = BooleanArray(26)
        for (character in s.toCharArray()) {
            if (!array[character - 'a']) {
                array[character - 'a'] = true
                counter++
            }
        }

        return counter
    }
}

/**
 * 395. Longest Substring with At Least K Repeating Characters
 *
 * Given:: s: String; k: Int
 * Return:: longest substring of s which frequency of each character is greater or equal to k
 *
 *
 * Intuition
 * First think can we apply sliding window technique here?
 * Before giving yes or no answer lets try to use it.
 *
 * So our string is "aaabb" and k = 3 that means in our target substring each char's frequency must be greater or equal than k.
 *
 * So lets start from first. i = 0 to s.length() - 1
 * i = 0 -> we have 'a' as it is first character so frequency is 1 which is less than k so we need to move further.
 *
 * i = 1 -> we have 'a'. So previously we have 'a' already now another 'a' so total 2 a. Frequency is 2 still it is less than k.
 *
 * i = 2 -> we have 'a' also. So considering this the frequency is 3. Which is equal to k so our condition satisfied and we can calculate substring length which is 3.
 *
 * Now should we shrink the window or expand? There can be more 'a' or more other characters. So we could not decide to shrink. Lets move
 *
 * i = 3 -> We have 'b'. So it is new character and its frequency is 1 which is less than k. So as our condition is broken we could not calculate substring length.
 *
 * Now what? Still we don't know should we shrink the window because if two more b comes our condition will satisfy. so we could not shrink . This is the problem. In any position we don't have any logic to shrink the window.
 *
 * So what can we do? Can we think of any logic so that we can shrink the window.
 *
 * Approach
 * So when we are creating a window consider the maxUniqueCharCount. MaxUniqueCharcount can be determined from the given string.
 * Here above example we have 2 unique characters.
 *
 * So our idea is we start from 1 to maxUniqueCharCount and operate out sliding window based on this condition and also the given k condition. What that means?
 *
 * Lets find it. We have 2 unique characters.
 *
 * Starting maxUniqueCharCount = 1
 * So our slidingWindow must have maximum one unique character. If unique is greater than maxUniqueCharCount we will shrink the window. Otherwise if unique character count is less than maxUniqueCharCount and also the frequency of each unique character is greater or equal k than we caculate the substring.
 *
 * maxUniqueCharCount = 1
 * i = 0 -> we have 'a'. Unique count 1 but frequency less than k so move forward
 * i = 1 -> we have again 'a'. Unique count still 1 but frequency is 2 which is less than k. Move forward
 * i = 2 -> We have also 'a'. Unique count still 1 but this time frequncy is 3 which is equal k. So calculate substring length which is 3 here. Still everything ok. So move forward
 * i = 3 -> We have 'b'. Unique count is now 2 which is grater than maxUniqueCharCount. So we need to shrink the winsow. So start shrinking from the window start which is i = 0.
 *
 * Remove i = 0 which is 'a' from window. But still unique count is 2. Shrink again i = 1 which is 'a' but still unique count = 2 as sliding window has 1 a and 1 b chars.. So we need to shrink again. i = 2 now after removing this window has only 1 unique character which satisfy our maxUniqueCharCount condition.
 * As frequency of this unique char is less than k so we could not calculate substring length. So move forward.
 *
 * i = 4 -> we have b. Unique char count still 1. But frequency of that is 2 which is less than k. So could not calculate the length.
 *
 * End of string.
 *
 * So considering maxUniqueCharCount = 1 we got maxSubstringLength = 3
 *
 * Now consider
 * maxUniqueCharCount = 2
 *
 * i = 0 -> we have 'a'. Unique count 1 but frequency less than k so move forward
 * i = 1 -> we have again 'a'. Unique count still 1 but frequency is 2 which is less than k. Move forward
 * i = 2 -> We have also 'a'. Unique count still 1 but this time frequncy is 3 which is equal k. So calculate substring length which is 3 here. Still everything ok. So move forward
 * i = 3 -> We have 'b'. Unique count 2 which satisfy maxUniqueCharCount condition. But frequency of b is less than k so could not calculate
 * i = 4 -> We have again 'b'. Unique count 2 which satisfy maxUniqueCharCount condition. But frequency of b is less than k so could not calculate.
 *
 * We don't need to look more as we already checked all possiblity of unique characters.
 *
 * public int longestSubstring(String s, int k) {
 *         int maxUnqiueCharCount =  getUniqueCharCount(s);
 *         int [] freqMap = new int [26];
 *         int result = 0;
 *
 *         for (int currentUniqueChar = 1;  currentUniqueChar <= maxUnqiueCharCount; currentUniqueChar++) {
 *             Arrays.fill(freqMap, 0);
 *             int uniqueCount = 0, countAtLeastK = 0, windowStart  = 0, windowEnd = 0;
 *
 *             while (windowEnd < s.length()) {
 *
 *                 if (uniqueCount <= currentUniqueChar) {
 *                     int idx = s.charAt(windowEnd) - 'a';
 *                     if (freqMap[idx] == 0) {
 *                         uniqueCount++;
 *                     }
 *                     freqMap[idx]++;
 *
 *                     if (freqMap[idx] == k) {
 *                         countAtLeastK++;
 *                     }
 *                     windowEnd++;
 *                 } else {
 *                     // We need to  shrink
 *                     int idx = s.charAt(windowStart) - 'a';
 *                     if (freqMap[idx] == k) {
 *                         countAtLeastK--;
 *                     }
 *                     freqMap[idx]--;
 *                     if (freqMap[idx] == 0) {
 *                         uniqueCount--;
 *                     }
 *                     windowStart++;
 *                 }
 *
 *                 if (uniqueCount == currentUniqueChar && uniqueCount == countAtLeastK) {
 *                     result = Math.max(windowEnd - windowStart, result);
 *                 }
 *             }
 *
 *         }
 *
 *         return result;
 *     }
 *
 *     private int getUniqueCharCount(String s) {
 *         boolean [] chars = new boolean [26];
 *         int uniqueCount = 0;
 *
 *         for (char ch : s.toCharArray()) {
 *             int idx  = ch - 'a';
 *             if (!chars[idx]) {
 *                 uniqueCount++;
 *                 chars[idx] = true;
 *             }
 *         }
 *
 *         return uniqueCount;
 *     }
 * Complexity
 * Time complexity:
 * A string may contains max 26 unique characters. So we need to do the sliding window techniques max 26 times. So time complexity is O(26n) = O(n) where n is the length of the string.
 *
 * Space complexity:
 * In each iteration we just tracking the frequency of the window which requires max 26. So we can consider it O(1).
 *
 * source: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/solutions/2821874/why-sliding-window-works-for-this-qustion-and-how-it-works-simple-analysis/?envType=problem-list-v2&envId=sliding-window
 */