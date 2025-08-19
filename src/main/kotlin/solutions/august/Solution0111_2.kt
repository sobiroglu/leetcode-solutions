package com.sobiroglu.solutions.august

import TreeNode

class Solution0111_2 {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return depth(root, 1)
    }

    private fun depth(node: TreeNode?, currentDepth: Int): Int {
        if (node == null) return 0
        if (node.right == null && node.left == null) return 1

        val left = depth(node.left, currentDepth)
        val right = depth(node.right, currentDepth)

        return 1 + minOf(
            if (left == 0) Int.MAX_VALUE else left,
            if (right == 0) Int.MAX_VALUE else right
        )
    }
}