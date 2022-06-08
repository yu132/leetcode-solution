package redo.p1000_1099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1090  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月16日  
 *  
 */
public class P1090 {

    static//

    class Solution {

        public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
            ListMap<Integer, Integer> listMap = new ListMap<>();
            for (int i = 0; i < values.length; ++i) {
                listMap.add(labels[i], values[i]);
            }
            List<List<Integer>> vals = new ArrayList<>(listMap.map.values());

            for (List<Integer> list : vals) {
                Collections.sort(list, (a, b) -> Integer.compare(b, a));
            }

            int[] initArr = new int[vals.size()], count = new int[vals.size()];
            for (int i = 0; i < vals.size(); ++i) {
                initArr[i] = vals.get(i).get(0);
            }

            LoserTree loserTree = new LoserTree(initArr);

            int sum = 0;

            while (num_wanted-- > 0) {
                if (loserTree.winner() == -1) {// 值不够num_wanted那么多
                    return sum;
                }
                sum += loserTree.winner();
                int index = loserTree.winnerIndex();
                ++count[index];
                if (count[index] == use_limit || count[index] == vals.get(index).size()) {
                    loserTree.replayWinner(-1);
                } else {
                    loserTree.replayWinner(vals.get(index).get(count[index]));
                }
            }

            return sum;
        }

        static class LoserTree {

            int[] tree, values;
            Comparator<Integer> comparator;

            public LoserTree(int[] values) {
                this(values, Integer::compare);
            }

            public LoserTree(int[] values, Comparator<Integer> comparator) {
                int n = values.length;
                tree = new int[n];
                this.values = new int[n + 1];
                this.values[n] = Integer.MAX_VALUE;
                this.comparator = comparator;
                System.arraycopy(values, 0, this.values, 0, n);
                Arrays.fill(tree, n);
                for (int i = n - 1; i >= 0; --i) {
                    replay(i);
                }
            }

            private void replay(int index) {
                int winner = index, parent = (index + tree.length) / 2;
                while (parent > 0) {
                    if (comparator.compare(values[winner], values[tree[parent]]) < 0) {// 比不过
                        int temp = winner;
                        winner = tree[parent];
                        tree[parent] = temp;
                    }
                    parent /= 2;
                }
                tree[0] = winner;
            }

            void replayWinner(int val) {
                values[tree[0]] = val;
                replay(tree[0]);
            }

            int winner() {
                return values[tree[0]];
            }

            int winnerIndex() {
                return tree[0];
            }
        }

        static class ListMap<K, E> {

            Map<K, List<E>> map = new HashMap<>();

            public void add(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).add(element);
            }

            public void remove(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).remove(element);
            }

            public List<E> get(K key) {
                return map.getOrDefault(key, Collections.emptyList());
            }

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(9, s.largestValsFromLabels(new int[] {5, 4, 3, 2, 1}, new int[] {1, 1, 2, 2, 3}, 3, 1));
        Assert.assertEquals(12, s.largestValsFromLabels(new int[] {5, 4, 3, 2, 1}, new int[] {1, 3, 3, 3, 2}, 3, 2));
        Assert.assertEquals(16, s.largestValsFromLabels(new int[] {9, 8, 8, 7, 6}, new int[] {0, 0, 0, 1, 1}, 3, 1));
        Assert.assertEquals(24, s.largestValsFromLabels(new int[] {9, 8, 8, 7, 6}, new int[] {0, 0, 0, 1, 1}, 3, 2));
    }

}
