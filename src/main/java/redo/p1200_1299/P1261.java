package redo.p1200_1299;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1261  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1261 {

    class FindElements {

        TreeNode root;

        public FindElements(TreeNode root) {
            this.root = root;
            recover(root, 0);
        }

        void recover(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            root.val = val;
            recover(root.left, 2 * val + 1);
            recover(root.right, 2 * val + 2);
        }

        public boolean find(int target) {
            List<Integer> list = new ArrayList<>();
            list.add(target);
            while (target != 0) {
                if (target % 2 == 0) {
                    target = (target - 2) / 2;
                } else {
                    target = (target - 1) / 2;
                }
                list.add(target);
            }
            return find(list.size() - 1, root, list);
        }

        public boolean find(int index, TreeNode node, List<Integer> list) {
            if (index == -1) {
                return true;
            }
            if (node == null) {
                return false;
            }
            if (node.val == list.get(index)) {
                return find(index - 1, node.left, list) || find(index - 1, node.right, list);
            }
            return false;
        }
    }



    @Test
    public void test() {
        FindElements s = new FindElements(BinaryTreeTestUtil.build("[-1,null,-1]"));
        Assert.assertEquals(false, s.find(1));
        Assert.assertEquals(true, s.find(2));
    }

    @Test
    public void test2() {
        FindElements s = new FindElements(BinaryTreeTestUtil.build("[-1,-1,-1,-1,-1]"));
        Assert.assertEquals(true, s.find(1));
        Assert.assertEquals(true, s.find(3));
        Assert.assertEquals(false, s.find(5));
    }

    @Test
    public void test3() {
        FindElements s = new FindElements(BinaryTreeTestUtil.build("[-1,null,-1,-1,null,-1]"));
        Assert.assertEquals(true, s.find(2));
        Assert.assertEquals(false, s.find(3));
        Assert.assertEquals(false, s.find(4));
        Assert.assertEquals(true, s.find(5));
    }

}
