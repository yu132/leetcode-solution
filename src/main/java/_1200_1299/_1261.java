package _1200_1299;

import java.util.HashSet;

import model.TreeNode;

/**  
 * @ClassName: _1261  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月10日  
 *  
 */
public class _1261 {

    class FindElements {

        HashSet<Integer> set = new HashSet<Integer>(20000);

        public FindElements(TreeNode root) {
            recover(root, 0);
        }

        public void recover(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            set.add(val);
            recover(root.left, val * 2 + 1);
            recover(root.right, val * 2 + 2);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }

}
