package com.sobiroglu.solutions.september

class Solution0119_1 {
    fun getRow(rowIndex: Int): List<Int> {
        /*val pascalsTriangle = Array(rowIndex + 1) {
            Array(rowIndex + 1) { index ->
                if (index == 0) 1 else 0
            }
        }*/
        val row = MutableList(rowIndex + 1) { 0 }
        row[0] = 1
        for (i in 1 .. rowIndex) {
            for (j in i downTo 1) {
                row[j] = row[j] + row[j - 1]
            }
        }

        return row
    }
}

/**
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 *
 * on the second we are using different approach
 * let's say we need to find 4-th row index
 *
 * initially we have
 *
 * 0 0 0 0 0 - 5 elements and all of them are 0 (because 4th row contains 5 elements)
 * 1 0 0 0 0 - we are initialize first element to 1
 *
 * we start iterate over elements
 *
 *   |
 * 1 0 0 0 0 - initially our inner pointer in the 2nd element (1st index)
 *     |
 * 1 1 0 0 0 - then we move pointer to 3rd element (2nd index)
 *       |
 * 1 2 1 0 0 - we continue moving pointer to 4th element (3rd index)
 *         |
 * 1 3 3 1 0 - then move the pointer to 5th element (4th index)
 *           |
 * 1 4 6 4 1   - now pointer came out of the index. we stop here and it's our result
 *
 */