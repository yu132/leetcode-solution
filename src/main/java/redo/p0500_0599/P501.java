package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P501  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P501 {

    class Solution {
        public int[] findMode(TreeNode root) {
            Data data = new Data();
            List<Integer> mode = new ArrayList<>();
            morrisInorder(root, (node) -> {
                if (data.val != node.val) {
                    if (data.num == data.max) {
                        mode.add(data.val);
                    } else if (data.num > data.max) {
                        data.max = data.num;
                        mode.clear();
                        mode.add(data.val);
                    }
                    data.val = node.val;
                    data.num = 1;
                } else {
                    ++data.num;
                }
            });
            if (data.num == data.max) {
                mode.add(data.val);
            } else if (data.num > data.max) {
                mode.clear();
                mode.add(data.val);
            }
            return copy(mode);
        }

        class Data {
            int val = -486415616;
            int num = -1;
            int max = 0;
        }

        public int[] copy(List<Integer> list) {
            int[] nums = new int[list.size()];
            for (int i = 0; i < list.size(); ++i) {
                nums[i] = list.get(i);
            }
            return nums;
        }

        public void morrisInorder(TreeNode root, Consumer<TreeNode> visiter) {
            TreeNode current = root;
            while (current != null) {
                if (current.left == null) {
                    visiter.accept(current);
                    current = current.right;
                } else {

                    TreeNode maxLeftChild = current.left;
                    while (maxLeftChild.right != null && maxLeftChild.right != current) {
                        maxLeftChild = maxLeftChild.right;
                    }

                    if (maxLeftChild.right != current) {
                        maxLeftChild.right = current;
                        current = current.left;
                    }

                    else {
                        visiter.accept(current);
                        maxLeftChild.right = null;
                        current = current.right;
                    }
                }
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2}, s.findMode(BinaryTreeTestUtil.build("1,null,2,2")));

        s = new Solution();
        assertArrayEquals(new int[] {1, 2}, s.findMode(BinaryTreeTestUtil.build("1,1,2,null,null,2")));

        s = new Solution();
        assertArrayEquals(new int[] {2, 6}, s.findMode(BinaryTreeTestUtil.build("[6,2,8,0,4,7,9,null,null,2,6]")));
    }

}
