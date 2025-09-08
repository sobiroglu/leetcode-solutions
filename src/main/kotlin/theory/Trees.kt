
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(1)
    
    val leftChild = TreeNode(2)
    val rightChild = TreeNode(3)

    root.left = leftChild
    root.right = rightChild

    val leftGrandChild = TreeNode(4)

    leftChild.left = leftGrandChild
}

// height of the tree
fun height(node: TreeNode?): Int {
    if (node == null) {
        return 0
    }
    return 1 + Math.max(height(node.left), height(node.right))
}

// depth of the specific node
fun depth(node: TreeNode?, `val`: Int, currentDepth: Int):Int? {
    if (node == null) {
        return null
    }
    if (node.`val` == `val`) {
        return currentDepth
    }
    val left = depth(node.left, `val`, currentDepth + 1)
    val right = depth(node.right, `val`, currentDepth + 1)
    return left ?: right
}
