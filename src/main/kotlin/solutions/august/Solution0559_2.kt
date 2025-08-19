package solutions.august


class Solution0559_2 {
    fun maxDepth(root: Node?): Int {
        if (root == null) return 0
        return dfs(root, 1)
    }

    private fun dfs(node: Node?, curLevel: Int): Int {
        if (node == null || node.children.isEmpty()) return curLevel
        return node.children.maxOf { dfs(it, curLevel + 1) }
    }
}