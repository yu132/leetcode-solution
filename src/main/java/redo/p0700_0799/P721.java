package redo.p0700_0799;

import java.util.*;

public class P721 {

    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            RankedUnionFind unionFind = new RankedUnionFind(accounts.size());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < accounts.size(); ++j) {
                List<String> accountList = accounts.get(j);
                for (int i = 1; i < accountList.size(); ++i) {
                    if (map.containsKey(accountList.get(i))) {
                        unionFind.union(j, map.get(accountList.get(i)));
                    } else {
                        map.put(accountList.get(i), j);
                    }
                }
            }
            ListMap<Integer, String> ans = new ListMap<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                ans.add(unionFind.find(entry.getValue()), entry.getKey());
            }
            List<List<String>> result = new ArrayList<>();
            for (Map.Entry<Integer, List<String>> entry : ans.map.entrySet()) {
                List<String> list = entry.getValue();
                Collections.sort(list);
                list.add(0, accounts.get(entry.getKey()).get(0));
                result.add(list);
            }
            return result;
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

        public class RankedUnionFind {
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
                    parent[typeX] = typeY;
                } else {
                    parent[typeY] = typeX;
                    rank[typeX] += 1;
                }
                --connectedComponentCount;
            }

            public int find(int x) {
                return parent[x] == x ? x : (parent[x] = find(parent[x]));
            }

            public boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }

            public int connectedComponentCount() {
                return connectedComponentCount;
            }
        }
    }

}
