package redo.p0900_0999;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P988  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P988 {

    class Solution {

        List<Integer> list;

        public String smallestFromLeaf(TreeNode root) {
            list = new ArrayList<>();
            dfs(root, new ArrayList<>());
            StringBuilder buf = new StringBuilder(list.size());
            for (int i = list.size() - 1; i >= 0; --i) {
                buf.append((char)('a' + list.get(i)));
            }
            return buf.toString();
        }

        void dfs(TreeNode node, List<Integer> now) {
            if (node == null) {
                return;
            }
            now.add(node.val);
            if (node.left == null && node.right == null) {
                if (list.size() == 0 || compare(now, list) < 0) {
                    list.clear();
                    list.addAll(now);
                }
            }
            dfs(node.left, now);
            dfs(node.right, now);
            now.remove(now.size() - 1);
        }

        int compare(List<Integer> list1, List<Integer> list2) {
            int i1 = list1.size() - 1, i2 = list2.size() - 1;
            while (i1 >= 0 && i2 >= 0) {
                if (list1.get(i1) > list2.get(i2)) {
                    return 1;
                }
                if (list1.get(i1) < list2.get(i2)) {
                    return -1;
                }
                --i1;
                --i2;
            }
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            } else {
                return 0;
            }
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("dba", s.smallestFromLeaf(BinaryTreeTestUtil.build("[0,1,2,3,4,3,4]")));
        Assert.assertEquals("adz", s.smallestFromLeaf(BinaryTreeTestUtil.build("[25,1,3,1,3,0,2]")));
        Assert.assertEquals("abc", s.smallestFromLeaf(BinaryTreeTestUtil.build("[2,2,1,null,1,0,null,0]")));
        Assert.assertEquals("bae", s.smallestFromLeaf(BinaryTreeTestUtil.build("[4,0,1,1]")));
    }

}
