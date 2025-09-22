package com.sobiroglu

import TreeNode
import com.sobiroglu.solutions.august.Solution0111
import com.sobiroglu.solutions.september.Solution0097_1
import com.sobiroglu.solutions.september.Solution0119_1
import com.sobiroglu.solutions.september.Solution0120_1


fun main() {
    /*val root = TreeNode(3)

    val leftChild = TreeNode(9)
    val rightChild = TreeNode(20)

    root.left = leftChild
    root.right = rightChild

    val leftGrandChild = TreeNode(15)
    val rightGrandChild = TreeNode(7)

    rightChild.left = leftGrandChild
    rightChild.right = rightGrandChild

    val obj = Solution0111()
    val result = obj.minDepth(root)
    val resultStr = buildString {
        append("result ")
        append(result)
    }
    print(resultStr)*/

    val data = listOf(
        listOf(-7),
        listOf(-2, 1),
        listOf(-5, -5, 9),
        listOf(-4, -5, 4, 4),
        listOf(-6, -6, 2, -1, -5),
        listOf(3, 7, 8, -3, 7, -9),
        listOf(-9, -1, -9, 6, 9, 0, 7),
        listOf(-7, 0, -6, -8, 7, 1, -4, 9),
        listOf(-3, 2, -6, -9, -7, -6, -9, 4, 0),
        listOf(-8, -6, -3, -9, -2, -6, 7, -5, 0, 7),
        listOf(-9, -1, -2, 4, -2, 4, 4, -1, 2, -5, 5),
        listOf(1, 1, -6, 1, -2, -4, 4, -2, 6, -6, 0, 6),
        listOf(-3, -3, -6, -2, -6, -2, 7, -9, -5, -7, -5, 5, 1)
    )

    val solution0097 = Solution0120_1()
    val a = solution0097.minimumTotal(listOf(listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3)))
    //val a = solution0097.minimumTotal(listOf(listOf(-11)))
    println(a)
}