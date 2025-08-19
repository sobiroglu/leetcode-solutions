package solutions.august

import TreeNode

/**
 * dfs + pruning solution
 * pruning — it avoids exploring paths that are guaranteed to be useless
 */
class Solution0111_Best {
    var answer = Int.MAX_VALUE
    fun minDepth(root: TreeNode?): Int {
        dfs(root, 1)
        return answer
    }

    private fun dfs(node: TreeNode?, curLevel: Int) {
        if (node == null) return
        if (curLevel >= answer) return
        if (node.right == null && node.left == null) {
            answer = minOf(curLevel, answer)
            return
        }
        dfs(node.left, curLevel + 1)
        dfs(node.right, curLevel + 1)
    }
}