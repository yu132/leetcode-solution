package redo.offer2.p17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: P17_07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
public class P17_07 {

    static//

    class Solution {
        public String[] trulyMostPopular(String[] names, String[] synonyms) {
            Map<String, Integer> count = new HashMap<>();

            Map<String, Integer> indexes = new HashMap<>();
            List<String> nameList = new ArrayList<>();

            List<List<Integer>> adjc = toAdjc(synonyms, indexes, nameList);

            for (int i = 0; i < names.length; ++i) {
                String nameAndCount = names[i];

                int index = nameAndCount.indexOf('(');

                String name = nameAndCount.substring(0, index);

                int c = Integer.valueOf(nameAndCount.substring(index + 1,
                    nameAndCount.length() - 1));

                count.put(name, c);

                if (!indexes.containsKey(name)) {
                    indexes.put(name, indexes.size());
                    nameList.add(name);
                    adjc.add(Collections.emptyList());
                }
            }

            Set<Integer> visited = new HashSet<>();

            List<String> ans = new ArrayList<>();

            for (int i = 0; i < nameList.size(); ++i) {
                if (visited.contains(i)) {
                    continue;
                }
                Data d = dfs(i, adjc, count, nameList, visited);

                ans.add(d.minName + '(' + d.count + ')');
            }

            return ans.toArray(new String[0]);
        }

        Data dfs(int index, List<List<Integer>> adjc,
            Map<String, Integer> count, List<String> nameList,
            Set<Integer> visited) {

            if (visited.contains(index)) {
                return null;
            }

            visited.add(index);

            String name = nameList.get(index);
            int c = count.getOrDefault(name, 0);

            for (int child : adjc.get(index)) {
                Data d = dfs(child, adjc, count, nameList, visited);
                if (d == null) {
                    continue;
                }
                c += d.count;
                name = name.compareTo(d.minName) <= 0 ? name : d.minName;
            }

            return new Data(name, c);
        }

        List<List<Integer>> toAdjc(String[] synonyms,
            Map<String, Integer> indexes, List<String> name) {

            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < synonyms.length; ++i) {
                String synonym = synonyms[i];

                int index = synonym.indexOf(',');

                String name1 = synonym.substring(1, index),
                    name2 = synonym.substring(index + 1, synonym.length() - 1);

                if (!indexes.containsKey(name1)) {
                    indexes.put(name1, indexes.size());
                    ans.add(new ArrayList<>());
                    name.add(name1);
                }

                if (!indexes.containsKey(name2)) {
                    indexes.put(name2, indexes.size());
                    ans.add(new ArrayList<>());
                    name.add(name2);
                }

                int x = indexes.get(name1), y = indexes.get(name2);

                ans.get(x).add(y);
                ans.get(y).add(x);
            }

            return ans;
        }

        static class Data {
            String minName;
            int count;

            public Data(String minName, int count) {
                super();
                this.minName = minName;
                this.count = count;
            }
        }

    }

    // class Solution {
    // public String[] trulyMostPopular(String[] names, String[] synonyms) {
    //
    // int n = names.length;
    //
    // UF uf = new UF(n);
    // Map<String, Integer> mapping = new HashMap<>();
    // int[] count = new int[n];
    // String[] nameStr = new String[n];
    //
    // for (int i = 0; i < n; ++i) {
    // String nameAndCount = names[i];
    //
    // int index = nameAndCount.indexOf('(');
    //
    // nameStr[i] = nameAndCount.substring(0, index);
    //
    // count[i] = Integer.valueOf(nameAndCount.substring(index + 1,
    // nameAndCount.length() - 1));
    //
    // mapping.put(nameStr[i], i);
    // }
    //
    // String[] min = Arrays.copyOf(nameStr, nameStr.length);
    //
    // for (int i = 0; i < synonyms.length; ++i) {
    // String synonym = synonyms[i];
    //
    // int index = synonym.indexOf(',');
    //
    // String name1 = synonym.substring(1, index),
    // name2 = synonym.substring(index + 1, synonym.length() - 1);
    //
    // int x = mapping.getOrDefault(name1, -1),
    // y = mapping.getOrDefault(name2, -1);
    //
    // if (x == -1 || y == -1) {
    // if (x == -1 && y == -1) {
    // continue;
    // }
    // if (x == -1) {
    // int ty = uf.find(y);
    // if (name1.compareTo(min[ty]) < 0) {
    // min[ty] = name1;
    // }
    // } else if (y == -1) {
    // int tx = uf.find(x);
    // if (name2.compareTo(min[tx]) < 0) {
    // min[tx] = name2;
    // }
    // }
    // continue;
    // }
    //
    // int tx = uf.find(x), ty = uf.find(y);
    //
    // String minX = min[tx], minY = min[ty];
    //
    // uf.union(x, y);
    //
    // int type = uf.find(x);
    //
    // min[type] = minX.compareTo(minY) <= 0 ? minX : minY;
    // count[type] = count[tx] + count[ty];
    // }
    //
    // String[] ans = new String[uf.compCount];
    //
    // for (int i = 0, index = 0; i < n; ++i) {
    // if (i == uf.find(i)) {
    // ans[index++] = min[i] + '(' + count[i] + ')';
    // }
    // }
    //
    // return ans;
    // }
    //
    // static class UF {
    // int[] type;
    // int[] rank;
    //
    // int compCount;
    //
    // public UF(int len) {
    // super();
    // this.type = new int[len];
    // Arrays.setAll(type, (x) -> x);
    // this.rank = new int[len];
    // compCount = len;
    // }
    //
    // public void union(int x, int y) {
    // int tx = find(x), ty = find(y);
    //
    // if (tx == ty) {
    // return;
    // }
    //
    // if (rank[tx] >= rank[ty]) {
    // type[ty] = tx;
    // if (rank[tx] == rank[ty]) {
    // ++rank[tx];
    // }
    // } else if (rank[tx] < rank[ty]) {
    // type[tx] = ty;
    // }
    //
    // --compCount;
    // }
    //
    // public int find(int x) {
    // return type[x] == x ? x : (type[x] = find(type[x]));
    // }
    //
    // }
    // }

}
