package redo.Util;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author 余定邦
 * @ClassName: Trees
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月20日
 */
public class Trees {

    /**
     * 将父引用二叉树转换为普通二叉树
     */
    PTreeNode toNormalBinaryTree(int[] parents) {
        Map<Integer, PTreeNode> maps = new HashMap<>();
        PTreeNode head = null;
        for (int i = 0; i < parents.length; ++i) {
            PTreeNode node = new PTreeNode(i);
            if (parents[i] == -1) {
                head = node;
                continue;
            }
            PTreeNode parent = maps.computeIfAbsent(parents[i], PTreeNode::new);
            node.parent = parent;
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        return head;
    }

    /**
     * 将树按层级展平成列表，每层一个列表，按照从左到右的顺序排序
     *
     * @param root
     * @return
     */
    List<List<Integer>> flatByLevel(TreeNode root) {
        List<List<Integer>> collector = new ArrayList<>();
        dfsHelperFlatByLevel(root, 0, collector);
        return collector;
    }

    void dfsHelperFlatByLevel(TreeNode node, int level, List<List<Integer>> collector) {
        if (null == node) {
            return;
        }
        if (collector.size() == level) {
            collector.add(new ArrayList<>());
        }
        collector.get(level).add(node.val);
        dfsHelperFlatByLevel(node.left, level + 1, collector);
        dfsHelperFlatByLevel(node.right, level + 1, collector);
    }

    public class PTreeNode {
        int val;
        PTreeNode left;
        PTreeNode right;
        PTreeNode parent;

        public PTreeNode(int x) {
            val = x;
        }
    }

    /**
     * 将父引用树转换为普通树
     */
    NormalTreeNode toNormalTree(int[] parents) {
        Map<Integer, NormalTreeNode> maps = new HashMap<>();
        NormalTreeNode head = null;
        for (int i = 0; i < parents.length; ++i) {
            NormalTreeNode node = new NormalTreeNode(i);
            if (parents[i] == -1) {
                head = node;
                continue;
            }
            NormalTreeNode parent = maps.computeIfAbsent(parents[i], NormalTreeNode::new);
            node.parent = parent;
            parent.children.add(node);
        }
        return head;
    }

    public class NormalTreeNode {
        int val;
        NormalTreeNode parent;
        List<NormalTreeNode> children = new ArrayList<>();

        public NormalTreeNode(int val) {
            this.val = val;
        }
    }

    // 每个节点对应子树的和
    public int sumEachNode(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + sumEachNode(node.left, map) + sumEachNode(node.right, map);
        map.put(node, sum);
        return sum;
    }

    // 每个节点对应子树的节点数
    public int countEachNode(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        int sum = 1 + sumEachNode(node.left, map) + sumEachNode(node.right, map);
        map.put(node, sum);
        return sum;
    }

    // 每个节点对应子树的深度
    public int depthEachNode(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        int depth = 1 + Math.max(depthEachNode(node.left, map), depthEachNode(node.right, map));
        map.put(node, depth);
        return depth;
    }

    public void inorder(TreeNode node, Consumer<Integer> visitor) {
        if (node == null) {
            return;
        }
        inorder(node.left, visitor);
        visitor.accept(node.val);
        inorder(node.right, visitor);
    }

    public void inOrder(TreeNode node, Consumer<TreeNode> visitor) {
        if (node == null) {
            return;
        }
        inOrder(node.left, visitor);
        visitor.accept(node);
        inOrder(node.right, visitor);
    }

    public void preorder(TreeNode node, Consumer<Integer> visitor) {
        if (node == null) {
            return;
        }
        visitor.accept(node.val);
        inorder(node.left, visitor);
        inorder(node.right, visitor);
    }

    public void preOrder(TreeNode node, Consumer<TreeNode> visitor) {
        if (node == null) {
            return;
        }
        visitor.accept(node);
        inOrder(node.left, visitor);
        inOrder(node.right, visitor);
    }

    public void postorder(TreeNode node, Consumer<Integer> visitor) {
        if (node == null) {
            return;
        }
        inorder(node.left, visitor);
        inorder(node.right, visitor);
        visitor.accept(node.val);
    }

    public void postOrder(TreeNode node, Consumer<TreeNode> visitor) {
        if (node == null) {
            return;
        }
        inOrder(node.left, visitor);
        inOrder(node.right, visitor);
        visitor.accept(node);
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

    TreeNode minRight(TreeNode node) {
        TreeNode n = node.right;
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    List<TreeNode> ancestorsOf(TreeNode node, TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        ancestorsOfHelper(node, root, ans);
        return ans;
    }

    boolean ancestorsOfHelper(TreeNode target, TreeNode now, List<TreeNode> ans) {
        if (now == null) {
            return false;
        }
        if (now == target) {
            return true;
        }
        ans.add(now);
        if (ancestorsOfHelper(target.left, now, ans)) {
            return true;
        }
        if (ancestorsOfHelper(target.right, now, ans)) {
            return true;
        }
        ans.remove(ans.size() - 1);
        return false;
    }

    /**
     * 找到一棵树中小于等于目标值的最大值
     *
     * @param root
     * @param val
     * @return
     */
    public int findMaxEqualSmaller(TreeNode root, int val) {
        if (null == root) {
            return -1;
        }
        if (root.val == val) {
            return val;
        }
        if (root.val < val) {
            int dd = findMaxEqualSmaller(root.right, val);
            if (-1 == dd || dd < root.val) {
                return root.val;
            } else {
                return dd;
            }
        } else {
            return findMaxEqualSmaller(root.left, val);
        }
    }

    /**
     * 找到一棵树中大于等于目标值的最小值
     *
     * @param root
     * @param val
     * @return
     */
    public int findMinEqualLager(TreeNode root, int val) {
        if (null == root) {
            return -1;
        }
        if (root.val == val) {
            return val;
        }
        if (root.val < val) {
            return findMinEqualLager(root.right, val);
        } else {
            int dd = findMinEqualLager(root.left, val);
            if (-1 == dd || dd > root.val) {
                return root.val;
            } else {
                return dd;
            }
        }
    }

}
