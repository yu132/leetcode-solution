package _0600_0699;

import java.util.Arrays;

/**  
 * @ClassName: _684  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月17日  
 *  
 */
public class _684 {

    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            UF uf = new UF(edges.length + 1);

            for (int[] edge : edges) {

                if (uf.connected(edge[0], edge[1])) {
                    return edge;
                }

                uf.union(edge[0], edge[1]);
            }

            return null;
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
