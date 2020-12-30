package redo.Util;

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

}
