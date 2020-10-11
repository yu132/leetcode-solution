package _0500_0599;

import java.util.Arrays;

/**  
 * @ClassName: _547  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月30日  
 *  
 */
public class _547 {

    class Solution {
        public int findCircleNum(int[][] M) {
            UF uf = new UF(M.length);

            for (int i = 0; i < M.length; ++i) {
                for (int j = i + 1; j < M[0].length; ++j) {
                    if (M[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }

            return uf.count;
        }

        // 可复制版本
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
