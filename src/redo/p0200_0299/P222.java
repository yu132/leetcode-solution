package redo.p0200_0299;

import model.TreeNode;

/**  
 * @ClassName: P222  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P222 {

    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            helper(root, 0);
            if (maxLevel == 0) {
                return 1;
            }
            return (int)(Math.pow(2, maxLevel) - 1 + lastCount);
        }

        boolean needFind = true;
        int maxLevel = 0;
        int lastCount = 0;

        void helper(TreeNode root, int level) {
            if (!needFind) {
                return;
            }
            if (root == null) {
                if (level == maxLevel) {
                    needFind = false;
                }
                return;
            }
            if (level > maxLevel) {
                maxLevel = level;
                lastCount = 0;
            }
            if (level == maxLevel) {
                ++lastCount;
            }
            helper(root.left, level + 1);
            helper(root.right, level + 1);
        }
    }

}
