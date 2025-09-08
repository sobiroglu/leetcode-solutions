package com.sobiroglu

import TreeNode
import com.sobiroglu.solutions.august.Solution0111


fun main() {
    val root = TreeNode(3)

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
    print(resultStr)
}