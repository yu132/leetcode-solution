package old._0600_0699;

import java.util.Arrays;

/**  
 * @ClassName: _685  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月17日  
 *  
 */
public class _685 {

    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {

            UF    uf     = new UF(edges.length + 1);
            int[] parent = new int[edges.length + 1];

            Arrays.setAll(parent, (x) -> x);

            int conflict = -1;
            int cycle    = -1;

            for (int i = 0; i < edges.length; ++i) {
                int[] edge = edges[i];

                if (parent[edge[1]] != edge[1]) {// 发生冲突
                    conflict = i;
                } else {
                    parent[edge[1]] = edge[0];
                    if (uf.connected(edge[0], edge[1])) {
                        cycle = i;
                    } else {
                        uf.union(edge[0], edge[1]);
                    }
                }
            }

            if (conflict == -1) {
                return new int[] {edges[cycle][0], edges[cycle][1]};
            } else {
                if (cycle == -1) {
                    return new int[] {edges[conflict][0], edges[conflict][1]};
                } else {
                    return new int[] {parent[edges[conflict][1]], edges[conflict][1]};
                }
            }

        }

        public class UF {
            private int[] size;

            protected int count;

            protected int[] uf;

            public boolean connected(int element1, int element2) {
                return find(element1) == find(element2);
            }

            public int count() {
                return count;
            }

            public UF(int typeNumber) {
                this.uf = new int[typeNumber];
                count   = typeNumber;
                for (int i = 0; i < typeNumber; i++) {
                    uf[i] = i;
                }
                size  = new int[typeNumber];
                count = typeNumber;
                Arrays.fill(size, 1);
            }

            public int find(int element) {
                return uf[element] == element ? element : (uf[element] = find(uf[element]));
            }

            public void union(int element1, int element2) {
                int type1 = find(element1);
                int type2 = find(element2);

                if (type1 == type2)
                    return;

                if (size[type1] < size[type2]) {
                    uf[type1]    = type2;
                    size[type2] += size[type1];
                } else {
                    uf[type2]    = type1;
                    size[type1] += size[type2];
                }
                --count;
            }
        }
    }


}
