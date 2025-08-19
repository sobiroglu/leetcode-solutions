package com.sobiroglu.solutions.august

import TreeNode

class Solution0111_3 {
    fun minDepth(root: TreeNode?): Int {
        return dfs(root)
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0
        if (node.right == null && node.left == null) return 1

        return 1 + minOf(
            if (node.left == null) Int.MAX_VALUE else dfs(node.left),
            if (node.right == null) Int.MAX_VALUE else dfs(node.right)
        )
    }
}