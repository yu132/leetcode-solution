package redo.p0900_0999;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.Arrs;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P987  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P987 {

    static//

    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            Deque<Data> queue = new LinkedList<>();

            queue.offer(new Data(0, root));

            ListMap<Integer, Integer> xValsMapping = new ListMap<>(new TreeMap<>()),
                xLevelValsMapping = new ListMap<>(new HashMap<>());

            int size = 1;

            while (!queue.isEmpty()) {
                Data d = queue.poll();

                xLevelValsMapping.add(d.x, d.node.val);

                if (d.node.left != null) {
                    queue.offer(new Data(d.x - 1, d.node.left));
                }

                if (d.node.right != null) {
                    queue.offer(new Data(d.x + 1, d.node.right));
                }

                --size;
                if (size == 0) {
                    size = queue.size();
                    organize(xValsMapping, xLevelValsMapping);
                }
            }

            return new ArrayList<>(xValsMapping.map.values());
        }

        void organize(ListMap<Integer, Integer> xValsMapping, ListMap<Integer, Integer> xLevelValsMapping) {
            xLevelValsMapping.map.forEach((x, list) -> {
                Collections.sort(list);
                xValsMapping.get(x).addAll(list);
                list.clear();
            });
        }

        static class Data {
            int x;
            TreeNode node;

            public Data(int x, TreeNode node) {
                super();
                this.x = x;
                this.node = node;
            }
        }

        static class ListMap<K, E> {

            Map<K, List<E>> map;

            public ListMap(Map<K, List<E>> map) {
                this.map = map;
            }

            public void add(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).add(element);
            }

            public void remove(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).remove(element);
            }

            public List<E> get(K key) {
                return map.computeIfAbsent(key, (x) -> new ArrayList<>());
            }

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[9],[3,15],[20],[7]]",
            Arrs.toLStr(s.verticalTraversal(BinaryTreeTestUtil.build("[3,9,20,null,null,15,7]"))));
        Assert.assertEquals("[[4],[2],[1,5,6],[3],[7]]",
            Arrs.toLStr(s.verticalTraversal(BinaryTreeTestUtil.build("[1,2,3,4,5,6,7]"))));
    }

}
