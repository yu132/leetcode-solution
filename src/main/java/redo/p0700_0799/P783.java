package redo.p0700_0799;

import java.util.function.Consumer;

import model.TreeNode;

/**  
 * @ClassName: P783
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P783 {

    class Solution {
        public int minDiffInBST(TreeNode root) {
            Data data = new Data();
            morrisInorder(root, (node) -> {
                if (!data.init) {
                    data.last = node.val;
                    data.init = true;
                } else {
                    data.min = Math.min(data.min, node.val - data.last);
                    data.last = node.val;
                }
            });
            return data.min;
        }

        class Data {
            int last;
            int min = Integer.MAX_VALUE;
            boolean init = false;
        }

        public void morrisInorder(TreeNode root, Consumer<TreeNode> visiter) {
            TreeNode current = root;
            while (current != null) {
                if (current.left == null) {
                    visiter.accept(current);
                    current = current.right;
                } else {

                    TreeNode maxLeftChild = current.left;
                    while (maxLeftChild.right != null && maxLeftChild.right != current) {
                        maxLeftChild = maxLeftChild.right;
                    }

                    if (maxLeftChild.right != current) {
                        maxLeftChild.right = current;
                        current = current.left;
                    }

                    else {
                        visiter.accept(current);
                        maxLeftChild.right = null;
                        current = current.right;
                    }
                }
            }
        }
    }

}
