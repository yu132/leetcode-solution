package redo.p1700_1799;

import org.apache.commons.io.FileUtils;
import redo.testUtil.Arrs;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class P1719 {

    class Solution {
        public int checkWays(int[][] pairs) {
            //统计节点之间的关系
            ListMap<Integer, Integer> relations = new ListMap<>();
            for (int[] pair : pairs) {
                relations.add(pair[0], pair[1]);
                relations.add(pair[1], pair[0]);
            }
            //从小到大排序节点，从小的节点开始构建树
            List<Map.Entry<Integer, List<Integer>>> relationList = new ArrayList<>(relations.map.entrySet());
            relationList.sort(Comparator.comparingInt(x -> x.getValue().size()));

            //构建树
            HashSet<Integer> visited = new HashSet<>();
            int root = -1;
            Map<Integer, TreeNode> nodes = new HashMap<>(relations.map.size());
            boolean swapable = false;
            //按从小到大顺序遍历，以从叶子节点向上构建树
            for (Map.Entry<Integer, List<Integer>> entry : relationList) {
                int val = entry.getKey();
                TreeNode node = nodes.computeIfAbsent(val, TreeNode::new);
                visited.add(val);

                //查找和该节点有关系的节点，并删除已经遍历过的节点（子孙节点）
                Set<Integer> relation = new HashSet<>(relations.get(val));
                relation.removeIf(visited::contains);

                //删除子孙节点后，剩下的关系肯定是祖先节点，从小到大排序祖先节点(大小相同的情况下，总是选择序号小的节点，
                // 防止出现子节点有的选择了序号小的，有的选择了序号大的，导致出现树结构失效的情况)
                List<Integer> ancestors = new ArrayList<>(relation);
                ancestors.sort(Comparator.<Integer>comparingInt(x -> relations.get(x).size())
                        .thenComparing(x -> x));

                //一个节点没有祖先节点，应当为树的根
                if (ancestors.isEmpty()) {
                    //多根，不符合题意
                    if (root != -1) {
                        return 0;
                    }
                    root = val;
                    continue;
                }

                //祖先节点中最小的肯定是父节点
                TreeNode parent = nodes.computeIfAbsent(ancestors.get(0), TreeNode::new);
                parent.children.add(node);
                parent.size += node.size;

                //如果本节点和父节点大小一样，那么本节点和父节点之间可以互换，如果构建的树合法，那么最终的结果数为2
                if (relations.get(val).size() == relations.get(parent.val).size()) {
                    swapable = true;
                }
            }

            //检查构建出来的树，是否符合要求
            if (!dfs(nodes.get(root), 0, relations)) {
                return 0;
            }

            return swapable ? 2 : 1;
        }

        boolean dfs(TreeNode node, int level, ListMap<Integer, Integer> relations) {
            if (node == null) {
                return true;
            }
            //检查子孙节点+祖先节点的数量是否等于关系数量
            if (node.size + level - 1 != relations.get(node.val).size()) {
                return false;
            }
            //递归检查子节点
            for (TreeNode child : node.children) {
                if (!dfs(child, level + 1, relations)) {
                    return false;
                }
            }
            return true;
        }

        class TreeNode {
            int val;
            int size = 1;
            List<TreeNode> children = new ArrayList<>();

            public TreeNode(int val) {
                this.val = val;
            }
        }

        class ListMap<K, E> {

            Map<K, List<E>> map = new HashMap<>();

            public void add(K key, E element) {
                get(key).add(element);
            }

            public void remove(K key, E element) {
                get(key).remove(element);
            }

            public List<E> get(K key) {
                return map.computeIfAbsent(key, (x) -> new ArrayList<>());
            }

        }
    }

    public static void main(String[] args) throws IOException {
        new P1719().new Solution().checkWays(Arrs.build2D(FileUtils.readFileToString(new File("C:\\Users\\Administrator\\Desktop\\b.txt"), "UTF-8")));
    }

}
