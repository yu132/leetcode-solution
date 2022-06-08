package redo.p0400_0499;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

/**  
 * @ClassName: P437  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P437 {

    class Solution {
        public int pathSum(TreeNode root, int sum) {
            helper(root, sum);
            return ans;
        }

        int ans = 0;

        Map<Integer, Integer> helper(TreeNode node, int target) {

            if (node == null) {
                return Collections.emptyMap();
            }

            Map<Integer, Integer> mergeMap = new HashMap<>();

            Map<Integer, Integer> left = helper(node.left, target),
                right = helper(node.right, target);

            ans += left.getOrDefault(target - node.val, 0)
                + right.getOrDefault(target - node.val, 0);

            if (node.val == target) {
                ++ans;
            }

            left.forEach((k, v) -> {
                add(mergeMap, k + node.val, v);
            });

            right.forEach((k, v) -> {
                add(mergeMap, k + node.val, v);
            });

            add(mergeMap, node.val, 1);

            return mergeMap;
        }

        void add(Map<Integer, Integer> map, int key, int val) {
            map.put(key, map.getOrDefault(key, 0) + val);
        }
    }

}
