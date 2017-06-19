package com.franciscozuccala

import javax.swing.tree.TreeNode

@Suppress("UNCHECKED_CAST")
class RefiedTypeExample {
    fun <T> TreeNode.findParentOfType(clazz: Class<T>): T {
        var p = parent
        while (p != null && !clazz.isInstance(p)) {
            p = p.parent
        }
        return p as T
    }

    inline fun <reified T> TreeNode.findParentOfType():T?{
        var p = parent
        while (p != null && p !is T) {
            p = p.parent
        }
        return p as T?
    }
}