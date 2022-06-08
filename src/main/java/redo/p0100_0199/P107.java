package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P107  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P107 {

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            level(root, 0);
            Collections.reverse(ans);
            return ans;
        }

        public void level(TreeNode node, int level) {
            if (node != null) {
                if (ans.size() == level) {
                    ans.add(new ArrayList<>());
                }
                ans.get(level).add(node.val);
                level(node.left, level + 1);
                level(node.right, level + 1);
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("[[15,7],[9,20],[3]]",
            s.levelOrderBottom(BinaryTreeTestUtil.build("[3,9,20,null,null,15,7]")).toString().replaceAll("\\s", ""));
    }

}
