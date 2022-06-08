package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P257  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P257 {

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            helper(root, new StringBuilder(), ans);
            return ans;
        }

        public void helper(TreeNode node, StringBuilder sb, List<String> ans) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                sb.append(node.val);
                ans.add(sb.toString());
                return;
            }
            sb.append(node.val).append("->");
            helper(node.left, new StringBuilder(sb), ans);
            helper(node.right, new StringBuilder(sb), ans);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("[1->2->5, 1->3]", s.binaryTreePaths(BinaryTreeTestUtil.build("1,2,3,null,5")).toString());
    }

}
