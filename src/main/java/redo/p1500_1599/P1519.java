package redo.p1500_1599;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1519  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1519 {

    static//

    class Solution {
        public int[] countSubTrees(int n, int[][] edges, String labels) {
            @SuppressWarnings("unchecked")
            List<Integer>[] trees = new ArrayList[n];

            for (int i = 0; i < trees.length; ++i) {
                trees[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                trees[edge[0]].add(edge[1]);
                trees[edge[1]].add(edge[0]);
            }

            int[] ans = new int[n];

            dfs(0, trees, labels, ans, -1);

            return ans;
        }

        LowercaseLettersCounter dfs(int index, List<Integer>[] trees, String labels, int[] ans, int parent) {
            LowercaseLettersCounter counter = new LowercaseLettersCounter();
            counter.count(labels.charAt(index));

            List<Integer> children = trees[index];

            for (int child : children) {
                if (child == parent) {
                    continue;
                }
                counter.merge(dfs(child, trees, labels, ans, index));
            }

            ans[index] = counter.getCount(labels.charAt(index));
            return counter;
        }

        static class LowercaseLettersCounter {
            int[] count = new int[26];

            public void count(char ch) {
                ++count[getIndex(ch)];
            }

            public void count(String str) {
                for (char ch : str.toCharArray()) {
                    count(ch);
                }
            }

            public int getCount(char ch) {
                return count[getIndex(ch)];
            }

            public void merge(int[] count) {
                for (int i = 0; i < 26; ++i) {
                    this.count[i] += count[i];
                }
            }

            public void merge(LowercaseLettersCounter counter) {
                merge(counter.count);
            }

            private int getIndex(char ch) {
                return ch - 'a';
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 1, 1, 1, 1, 1, 1},
            s.countSubTrees(7, Arrs.build2D("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"), "abaedcd"));

        Assert.assertArrayEquals(new int[] {4, 2, 1, 1},
            s.countSubTrees(4, Arrs.build2D("[[0,1],[1,2],[0,3]]"), "bbbb"));

        Assert.assertArrayEquals(new int[] {3, 2, 1, 1, 1},
            s.countSubTrees(5, Arrs.build2D("[[0,1],[0,2],[1,3],[0,4]]"), "aabab"));

        Assert.assertArrayEquals(new int[] {1, 2, 1, 1, 2, 1},
            s.countSubTrees(6, Arrs.build2D("[[0,1],[0,2],[1,3],[3,4],[4,5]]"), "cbabaa"));

        Assert.assertArrayEquals(new int[] {6, 5, 4, 1, 3, 2, 1},
            s.countSubTrees(7, Arrs.build2D("[[0,1],[1,2],[2,3],[3,4],[4,5],[5,6]]"), "aaabaaa"));

        Assert.assertArrayEquals(new int[] {1, 1, 2, 1},
            s.countSubTrees(4, Arrs.build2D("[[0,2],[0,3],[1,2]]"), "aeed"));
    }

}
