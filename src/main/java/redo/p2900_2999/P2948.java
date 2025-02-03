package redo.p2900_2999;

import redo.Util.UnionFind;

import java.util.*;
import java.util.stream.Collectors;

public class P2948 {

    class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;
            RankedUnionFind uf = new RankedUnionFind(n);
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; ++i) {
                nodes[i] = new Node(nums[i], i);
            }
            Arrays.sort(nodes, Comparator.comparingInt(x -> x.val));
            for (int i = 1; i < n; ++i) {
                if (nodes[i].val - nodes[i - 1].val <= limit) {
                    uf.union(nodes[i - 1].idx, nodes[i].idx);
                }
            }
            Map<Integer, List<Node>> groupBy = new HashMap<>();
            for (Node node : nodes) {
                groupBy.computeIfAbsent(uf.find(node.idx), x -> new ArrayList<>()).add(node);
            }
            for (Map.Entry<Integer, List<Node>> group : groupBy.entrySet()) {
                List<Integer> idxs = group.getValue().stream().map(x -> x.idx).sorted().collect(Collectors.toList());
                for (int i = 0; i < idxs.size(); ++i) {
                    nums[idxs.get(i)] = group.getValue().get(i).val;
                }
            }
            return nums;
        }

        class Node {
            int val;
            int idx;

            public Node(int val, int idx) {
                this.val = val;
                this.idx = idx;
            }
        }

        public class RankedUnionFind {
            int connectedComponentCount, rank[], parent[];

            public RankedUnionFind(RankedUnionFind toCopy) {
                connectedComponentCount = toCopy.connectedComponentCount;
                rank = Arrays.copyOf(toCopy.rank, toCopy.rank.length);
                parent = Arrays.copyOf(toCopy.parent, toCopy.parent.length);
            }

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
