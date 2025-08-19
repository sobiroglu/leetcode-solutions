package solutions.august


class Solution0559 {
    var answer = 0
    fun maxDepth(root: Node?): Int {
        dfs(root, 1)
        return answer
    }

    private fun dfs(node: Node?, curLevel: Int) {
        if (node == null) return
        if (node.children.isEmpty()) {
            answer = maxOf(curLevel, answer)
        }
        node.children.forEach { child ->
            if(child?.children?.isEmpty() == true) {
                answer = maxOf(curLevel + 1, answer)
            }
            dfs(child, curLevel + 1)
        }
    }
}


class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}
