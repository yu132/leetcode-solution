package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1530  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1530 {

    static//

    class Solution {

        int ans;

        private int[] EMPTY_ARR;

        public int countPairs(TreeNode root, int distance) {
            EMPTY_ARR = new int[Math.max(2, distance)];
            ans = 0;
            helper(root, distance);
            return ans;
        }

        public int[] helper(TreeNode node, int distance) {
            if (node == null) {
                return EMPTY_ARR;
            }
            int[] dis = new int[Math.max(2, distance)];
            if (node.left == null && node.right == null) {
                dis[1] = 1;
                return dis;
            }
            int[] left = helper(node.left, distance);
            int[] right = helper(node.right, distance);
            int sum = sum(right);

            for (int i = 1; i < distance; ++i) {
                ans += left[i] * sum;
                sum -= right[distance - i];
            }

            for (int i = 2; i < distance; ++i) {
                dis[i] = left[i - 1] + right[i - 1];
            }

            return dis;
        }

        public static int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.countPairs(BinaryTreeTestUtil.build("[1,2,3,null,4]"), 3));
        Assert.assertEquals(2, s.countPairs(BinaryTreeTestUtil.build("[1,2,3,4,5,6,7]"), 3));
        Assert.assertEquals(1,
            s.countPairs(BinaryTreeTestUtil.build("[7,1,4,6,null,5,3,null,null,null,null,null,2]"), 3));
        Assert.assertEquals(0, s.countPairs(BinaryTreeTestUtil.build("[1]"), 1));
        Assert.assertEquals(1, s.countPairs(BinaryTreeTestUtil.build("[1,1,1]"), 2));
    }

}
