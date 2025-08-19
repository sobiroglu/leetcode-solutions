package com.sobiroglu.solutions.august

import TreeNode

class Solution0111 {
    fun minDepth(root: TreeNode?): Int {
        return depth(root, 1)
    }

    private fun depth(node: TreeNode?, currentDepth: Int): Int {
        if (node == null) return 0

        val left = depth(node.left, currentDepth)
        val right = depth(node.right, currentDepth)

        return when {
            right == 0 && left == 0 -> 1
            left == 0 -> right + 1
            right == 0 -> left + 1
            else -> minOf(left, right) + 1
        }
    }
}