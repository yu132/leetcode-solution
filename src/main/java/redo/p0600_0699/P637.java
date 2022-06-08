package redo.p0600_0699;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P637  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P637 {

    static//

    class Solution {

        Map<Integer, IntVar> count = new HashMap<>();

        public List<Double> averageOfLevels(TreeNode root) {
            count(root, 0);
            List<Double> ans = new ArrayList<>();
            for (int i = 0; i < count.size(); ++i) {
                ans.add(null);
            }
            for (Map.Entry<Integer, IntVar> entry : count.entrySet()) {
                ans.set(entry.getKey(), entry.getValue().val / entry.getValue().count);
            }
            return ans;
        }

        private void count(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            IntVar var = count.computeIfAbsent(level, (x) -> new IntVar());
            var.val += node.val;
            ++var.count;
            count(node.left, level + 1);
            count(node.right, level + 1);
        }

        static class IntVar {
            double val = 0;
            int count = 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(3.0, 14.5, 11.0),
            s.averageOfLevels(BinaryTreeTestUtil.build("3,9,20,null,null,15,7")));

        s = new Solution();
        Assert.assertEquals(Arrays.asList(2147483647.0, 2147483647.0),
            s.averageOfLevels(BinaryTreeTestUtil.build("2147483647,2147483647,2147483647")));
    }
}
