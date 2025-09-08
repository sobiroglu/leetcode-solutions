package com.sobiroglu.solutions.september

class Solution0095_1 {
    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0) return emptyList()
        return bst(start = 1, end = n)
    }

    fun bst(start: Int, end: Int): List<TreeNode?> {
        val list = mutableListOf<TreeNode?>()

        if (start > end) return listOf(null)

        if (start == end) return listOf(TreeNode(start))

        for (i in start..end) {
            val leftList = bst(start, i - 1)
            val rightList = bst(i + 1, end)

            leftList.forEach { leftNode ->
                rightList.forEach { rightNode ->
                    val currentNode = TreeNode(i)
                    currentNode.left = leftNode
                    currentNode.right = rightNode

                    list.add(currentNode)
                }
            }
        }
        return list
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}