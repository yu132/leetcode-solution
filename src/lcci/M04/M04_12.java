package lcci.M04;

import java.util.ArrayList;

import model.TreeNode;

/**  
 * @ClassName: M04_12  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月2日  
 *  
 */
public class M04_12 {

    class Solution {
        public int pathSum(TreeNode root, int sum) {
            return helper(new ArrayList<>(), root, sum);
        }

        public int helper(ArrayList<Integer> list, TreeNode node, int sum) {
            if (node == null) {
                return 0;
            }
            list.add(0);
            for (int i = 0; i < list.size(); ++i) {
                list.set(i, list.get(i) + node.val);
            }
            int count = 0;
            for (int i = 0; i < list.size(); ++i) {
                if (sum == list.get(i)) {
                    ++count;
                }
            }
            count += helper(list, node.left, sum);
            count += helper(list, node.right, sum);

            list.remove(list.size() - 1);
            for (int i = 0; i < list.size(); ++i) {
                list.set(i, list.get(i) - node.val);
            }
            return count;
        }
    }

}
