package redo.mianshi.p04;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P04_12  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_12 {

    class Solution {

        int ans;

        public int pathSum(TreeNode root, int sum) {
            ans = 0;
            Map<Integer, Integer> counter = new HashMap<>();
            add1(counter, 0);
            dfs(root, 0, sum, counter);
            return ans;
        }

        public void dfs(TreeNode node, int preSum, int target,
            Map<Integer, Integer> counter) {

            if (node == null) {
                return;
            }

            int preSumNow = preSum + node.val;

            ans += counter.getOrDefault(preSumNow - target, 0);

            add1(counter, preSumNow);

            dfs(node.left, preSumNow, target, counter);
            dfs(node.right, preSumNow, target, counter);

            minus1(counter, preSumNow);
        }

        public void add1(Map<Integer, Integer> counter, int key) {
            counter.put(key, counter.getOrDefault(key, 0) + 1);
        }

        public void minus1(Map<Integer, Integer> counter, int key) {
            counter.put(key, counter.getOrDefault(key, 0) - 1);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.pathSum(BinaryTreeTestUtil.build("[1,2]"), 4));
    }

}
