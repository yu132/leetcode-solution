package redo.p0800_0899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P863  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月28日  
 *  
 */
public class P863 {

    class Solution {

        List<Integer> ans;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            ans = new ArrayList<>();
            find(root, target, K);
            return ans;
        }

        public int find(TreeNode root, TreeNode target, int K) {
            if (root == null) {
                return -1;
            }
            if (root == target) {
                if (K == 0) {
                    ans.add(root.val);
                    return -1;
                }
                get(root.left, K - 1);
                get(root.right, K - 1);
                return K - 1;
            }
            int left = find(root.left, target, K);
            if (left > 0) {
                get(root.right, left - 1);
                return left - 1;
            } else if (left == 0) {
                ans.add(root.val);
                return -1;
            }
            int right = find(root.right, target, K);
            if (right > 0) {
                get(root.left, right - 1);
                return right - 1;
            } else if (right == 0) {
                ans.add(root.val);
                return -1;
            }
            return -1;
        }

        public void get(TreeNode root, int len) {
            if (root == null) {
                return;
            }
            if (len == 0) {
                ans.add(root.val);
                return;
            }
            get(root.left, len - 1);
            get(root.right, len - 1);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();

        TreeNode root = BinaryTreeTestUtil.build("[3,5,1,6,2,0,8,null,null,7,4]"),
            _5 = BinaryTreeTestUtil.find(root, 5);

        Assert.assertEquals(Arrays.asList(7, 4, 1), s.distanceK(root, _5, 2));
        Assert.assertEquals(Arrays.asList(6, 2, 3), s.distanceK(root, _5, 1));
        Assert.assertEquals(Arrays.asList(5), s.distanceK(root, _5, 0));
    }

}
