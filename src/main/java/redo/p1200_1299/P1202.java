package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1202  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1202 {

    static//

    class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            RankedUnionFind uf = new RankedUnionFind(s.length());

            for (List<Integer> pair : pairs) {
                uf.union(pair.get(0), pair.get(1));
            }

            char[] chs = s.toCharArray();

            List<List<Integer>> group = group(uf, s.length());

            for (List<Integer> indexes : group) {
                countSortLowerCase(new CharMockArrayImpl(indexes, chs));
            }

            return String.valueOf(chs);
        }

        public static void countSortLowerCase(CharMockArray arr) {
            int[] count = countLowerCase(arr);

            for (int i = 0, index = 0; i < 26; ++i) {
                for (int j = 0; j < count[i]; ++j) {
                    arr.set(index++, (char)('a' + i));
                }
            }
        }

        public static int[] countLowerCase(CharMockArray nums) {
            int[] count = new int[26];
            for (int i = 0; i < nums.size(); ++i) {
                ++count[nums.get(i) - 'a'];
            }
            return count;
        }

        static interface CharMockArray {
            int size();

            char get(int index);

            char set(int index, char val);
        }

        static class CharMockArrayImpl implements CharMockArray {

            List<Integer> indexes;
            char[] chs;

            public CharMockArrayImpl(List<Integer> indexes, char[] chs) {
                super();
                this.indexes = indexes;
                this.chs = chs;
            }

            @Override
            public int size() {
                return indexes.size();
            }

            @Override
            public char get(int index) {
                return chs[indexes.get(index)];
            }

            @Override
            public char set(int index, char val) {
                return chs[indexes.get(index)] = val;
            }

        }

        static List<List<Integer>> group(RankedUnionFind uf, int n) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                map.computeIfAbsent(uf.find(i), (x) -> new ArrayList<>()).add(i);
            }
            return new ArrayList<>(map.values());
        }

        public static class RankedUnionFind {
            int connectedComponentCount, rank[], parent[];

            public RankedUnionFind(int num) {
                super();
                rank = new int[num];
                Arrays.fill(rank, 1);
                parent = new int[num];
                Arrays.setAll(parent, (x) -> x);
                connectedComponentCount = num;
            }

            public void union(int x, int y) {
                int typeX = find(x), typeY = find(y);
                if (typeX == typeY) {
                    return;
                }
                if (rank[typeX] > rank[typeY]) {
                    parent[typeY] = typeX;
                } else if (rank[typeX] < rank[typeY]) {
                    parent[typeX] = y;
                } else {
                    parent[typeY] = typeX;
                    rank[typeX] += 1;
                }
                --connectedComponentCount;
            }

            public int find(int x) {
                return parent[x] == x ? x : (x = find(parent[x]));
            }

            public boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }

            public int connectedComponentCount() {
                return connectedComponentCount;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("bacd", s.smallestStringWithSwaps("dcab", Arrs.build2DL("[[0,3],[1,2]]")));
        Assert.assertEquals("abcd", s.smallestStringWithSwaps("dcab", Arrs.build2DL("[[0,3],[1,2],[0,2]]")));
        Assert.assertEquals("abc", s.smallestStringWithSwaps("cba", Arrs.build2DL("[[0,1],[1,2]]")));
    }

}
