package redo.Util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: Morris  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class Morris {

    /*
     * Morris先序遍历，对于一个节点，可能会有两次遍历的情况
     * 
     * 以如下的树为例:
     *               1
     *             /   \
     *            2     3
     *           / \   / \
     *          4   5 6   7
     * 首先进入根节点1-1，以下将以1-1为例记录节点，前面的1为节点的值，后面的1为遍历到这个节点的次数
     * 
     * 1-1
     * 对于一个有左子树的节点，需要找到其最大的左子树节点，即5，令next(5)=1，退出1-1，进入2-1
     * 
     * 2-1
     * 由于其有左子树，同理，另最大左子树节点4的next(4)=2，退出2-1，进入4-1
     * 
     * 4-1
     * 由于其无左子树，visit(4)，无左子树的节点，退出后只能遍历next(该节点)，因此退出4-1，进入2-2
     * 
     * 2-2
     * 由于2-2有左子树，因此寻找其最大的左子树节点，即4，发现next(4)==2，因此2为第二次遍历
     * 对于一个第二次遍历的节点，需要visit(2)，然后恢复4节点，令next(4)=null，然后退出2-2，进入5-1
     * 
     * 5-1
     * 由于5没有左子树，因此就只能visit(5)，然后退出5-1，进入1-2
     * 
     * 1-2
     * 同理，检查1的最大左子树节点时，发现其next(5)==1，因此1为第二次遍历，然后visit(1)，然后恢复5节点，令next(5)=null，
     * 然后退出1-1，进入3-1
     * 
     * 右子树3-1
     * 右子树同理，将3作为根节点进行下一轮的遍历，这里将不再赘述
     * 
     */
    public static void morrisInOrder(TreeNode root, Consumer<TreeNode> visiter) {
        TreeNode current = root;
        while (current != null) {
            if (hasNoLeftChild(current)) {// 当没有左孩子时，就遍历自己，然后遍历下一个节点（右子树或者祖先节点）
                visit(visiter, current);
                current = next(current);
            } else {// 当存在左孩子时，需要进行两次遍历
                TreeNode maxLeftChild = findMaxLeftChild(current);// 找到左子树中最大的节点

                /* 第一次路过有左子树的某个非叶节点 */
                if (next(maxLeftChild) != current) {// 最大的节点下一个不指向自己，证明左子树尚未遍历
                    setNext(maxLeftChild, current);// 将最大节点下一个指针指向自己
                    current = current.left;// 遍历左子树
                }

                /* 第二次路过有左子树的某个非叶节点 */
                else {// 最大的节点的下一个节点指向自己，表示左子树已经遍历完成
                    visit(visiter, current);// 遍历自己
                    recover(maxLeftChild);// 恢复用于记录的指针，将树恢复原状
                    current = next(current);// 遍历下一个节点（右子树或者祖先节点）
                }
            }
        }
    }

    // //可复制版本
    // public void morrisInorder(TreeNode root, Consumer<TreeNode> visiter) {
    // TreeNode current = root;
    // while (current != null) {
    // if (current.left == null) {
    // visiter.accept(current);
    // current = current.right;
    // } else {
    //
    // TreeNode maxLeftChild = current.left;
    // while (maxLeftChild.right != null && maxLeftChild.right != current) {
    // maxLeftChild = maxLeftChild.right;
    // }
    //
    // if (maxLeftChild.right != current) {
    // maxLeftChild.right = current;
    // current = current.left;
    // }
    //
    // else {
    // visiter.accept(current);
    // maxLeftChild.right = null;
    // current = current.right;
    // }
    // }
    // }
    // }

    public static void morrisPreOrder(TreeNode root, Consumer<TreeNode> visiter) {
        TreeNode current = root;
        while (current != null) {
            if (hasNoLeftChild(current)) {// 当没有左孩子时，就遍历自己，然后遍历下一个节点（右子树或者祖先节点）
                visit(visiter, current);
                current = next(current);
            } else {// 当存在左孩子时，需要进行两次遍历
                TreeNode maxLeftChild = findMaxLeftChild(current);// 找到左子树中最大的节点

                /* 第一次路过有左子树的某个非叶节点 */
                if (next(maxLeftChild) != current) {// 最大的节点下一个不指向自己，证明左子树尚未遍历
                    visit(visiter, current);// 遍历自己
                    setNext(maxLeftChild, current);// 将最大节点下一个指针指向自己
                    current = current.left;// 遍历左子树
                }

                /* 第二次路过有左子树的某个非叶节点 */
                else {// 最大的节点的下一个节点指向自己，表示左子树已经遍历完成
                    recover(maxLeftChild);// 恢复用于记录的指针，将树恢复原状
                    current = next(current);// 遍历下一个节点（右子树或者祖先节点）
                }
            }
        }
    }

    public static void morrisPostOrder(TreeNode root, Consumer<TreeNode> visiter) {
        morrisPostOrder(root, visiter, false);
    }

    public static void morrisPostOrder(TreeNode root, Consumer<TreeNode> visiter, boolean needRecover) {
        TreeNode fakeHead = new TreeNode(-1);
        fakeHead.left = root;
        TreeNode current = fakeHead;
        while (current != null) {
            if (hasNoLeftChild(current)) {// 当没有左孩子时，就遍历自己，然后遍历下一个节点（右子树或者祖先节点）
                current = next(current);
            } else {// 当存在左孩子时，需要进行两次遍历
                TreeNode maxLeftChild = findMaxLeftChild(current);// 找到左子树中最大的节点

                /* 第一次路过有左子树的某个非叶节点 */
                if (next(maxLeftChild) != current) {// 最大的节点下一个不指向自己，证明左子树尚未遍历
                    setNext(maxLeftChild, current);// 将最大节点下一个指针指向自己
                    current = current.left;// 遍历左子树
                }

                /* 第二次路过有左子树的某个非叶节点 */
                else {// 最大的节点的下一个节点指向自己，表示左子树已经遍历完成
                    recover(maxLeftChild);// 恢复用于记录的指针，将树恢复原状

                    reverseCurrentLeftToMaxLeftChild(current);// 反转左孩子到左子树最大节点的路径
                                                              // 保证遍历的顺序为左->(右->中)的(右->中)
                    TreeNode temp = maxLeftChild;
                    while (temp != null) {// 从左子树的最大节点到左孩子的顺序进行遍历
                        visit(visiter, temp);
                        temp = next(temp);
                    }

                    if (needRecover) {
                        reverseMaxLeftChildToCurrentLeft(maxLeftChild);// 恢复反转树
                    }

                    current = next(current);// 遍历下一个节点（右子树或者祖先节点）
                }
            }
        }
    }

    private static void reverseCurrentLeftToMaxLeftChild(TreeNode current) {
        reverse(current.left);
    }

    private static void reverseMaxLeftChildToCurrentLeft(TreeNode maxLeftChild) {
        reverse(maxLeftChild);
    }

    private static void reverse(TreeNode node) {
        TreeNode before = null;
        while (node != null) {
            TreeNode next = node.right;
            node.right = before;
            before = node;
            node = next;
        }
    }

    private static void recover(TreeNode maxLeftChild) {
        setNext(maxLeftChild, null);
    }

    private static void setNext(TreeNode node, TreeNode next) {
        node.right = next;
    }

    private static TreeNode findMaxLeftChild(TreeNode current) {
        TreeNode node = current.left;
        while (node.right != null && node.right != current) {
            node = node.right;
        }
        return node;
    }

    private static void visit(Consumer<TreeNode> visiter, TreeNode current) {
        visiter.accept(current);
    }

    private static boolean hasNoLeftChild(TreeNode current) {
        return current.left == null;
    }

    private static TreeNode next(TreeNode current) {
        return current.right;
    }

    @Test
    public void test() {
        List<Integer> ans = new ArrayList<>();
        TreeNode tree = BinaryTreeTestUtil.build("1,2,3,4,5,6,7");
        TreeNode trerSame = BinaryTreeTestUtil.build("1,2,3,4,5,6,7");
        morrisInOrder(tree, (node) -> {
            ans.add(node.val);
        });
        assertEquals(Arrays.asList(4, 2, 5, 1, 6, 3, 7), ans);
        assertTrue(BinaryTreeTestUtil.same(tree, trerSame));
    }

    @Test
    public void test2() {
        List<Integer> ans = new ArrayList<>();
        TreeNode tree = BinaryTreeTestUtil.build("1,2,3,4,5,6,7");
        TreeNode trerSame = BinaryTreeTestUtil.build("1,2,3,4,5,6,7");
        morrisPreOrder(tree, (node) -> {
            ans.add(node.val);
        });
        assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6, 7), ans);
        assertTrue(BinaryTreeTestUtil.same(tree, trerSame));
    }

    @Test
    public void test3() {
        List<Integer> ans = new ArrayList<>();
        TreeNode tree = BinaryTreeTestUtil.build("1,2,3,4,5,6,7");
        TreeNode trerSame = BinaryTreeTestUtil.build("1,2,3,4,5,6,7");
        morrisPostOrder(tree, (node) -> {
            ans.add(node.val);
        }, true);
        assertEquals(Arrays.asList(4, 5, 2, 6, 7, 3, 1), ans);
        assertTrue(BinaryTreeTestUtil.same(tree, trerSame));
    }
}
