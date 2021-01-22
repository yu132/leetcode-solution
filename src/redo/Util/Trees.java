package redo.Util;

import java.util.Map;
import java.util.function.Consumer;

import model.TreeNode;

/**  
 * @ClassName: Trees  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class Trees {

    // 每个节点对应子树的和
    public int sumEachNode(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + sumEachNode(node.left, map) + sumEachNode(node.right, map);
        map.put(node, sum);
        return sum;
    }

    // 每个节点对应子树的节点数
    public int countEachNode(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        int sum = 1 + sumEachNode(node.left, map) + sumEachNode(node.right, map);
        map.put(node, sum);
        return sum;
    }

    // 每个节点对应子树的深度
    public int depthEachNode(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        int depth = 1 + Math.max(depthEachNode(node.left, map), depthEachNode(node.right, map));
        map.put(node, depth);
        return depth;
    }

    public void inorder(TreeNode node, Consumer<Integer> visiter) {
        if (node == null) {
            return;
        }
        inorder(node.left, visiter);
        visiter.accept(node.val);
        inorder(node.right, visiter);
    }

    public void inOrder(TreeNode node, Consumer<TreeNode> visiter) {
        if (node == null) {
            return;
        }
        inOrder(node.left, visiter);
        visiter.accept(node);
        inOrder(node.right, visiter);
    }

    public void preorder(TreeNode node, Consumer<Integer> visiter) {
        if (node == null) {
            return;
        }
        visiter.accept(node.val);
        inorder(node.left, visiter);
        inorder(node.right, visiter);
    }

    public void preOrder(TreeNode node, Consumer<TreeNode> visiter) {
        if (node == null) {
            return;
        }
        visiter.accept(node);
        inOrder(node.left, visiter);
        inOrder(node.right, visiter);
    }

    public void postorder(TreeNode node, Consumer<Integer> visiter) {
        if (node == null) {
            return;
        }
        inorder(node.left, visiter);
        inorder(node.right, visiter);
        visiter.accept(node.val);
    }

    public void postOrder(TreeNode node, Consumer<TreeNode> visiter) {
        if (node == null) {
            return;
        }
        inOrder(node.left, visiter);
        inOrder(node.right, visiter);
        visiter.accept(node);
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

}
