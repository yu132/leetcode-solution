package redo.Util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Test;

/**  
 * @ClassName: UnionFind  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月23日  
 *  
 */
public class UnionFind {

    public static class WeightedUnionFind {
        int connectedComponentCount, weight[], parent[];

        public WeightedUnionFind(int num) {
            super();
            weight = new int[num];
            Arrays.fill(weight, 1);
            parent = new int[num];
            Arrays.setAll(parent, (x) -> x);
            connectedComponentCount = num;
        }

        public void union(int x, int y) {
            int typeX = find(x), typeY = find(y);
            if (typeX == typeY) {
                return;
            }
            if (weight[typeX] >= weight[typeY]) {
                parent[typeY] = typeX;
                weight[typeX] += weight[typeY];
            } else {
                parent[typeX] = y;
                weight[typeY] += weight[typeX];
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

    @Test
    public void test() {
        WeightedUnionFind uf = new WeightedUnionFind(10);
        assertEquals(1, uf.find(1));
        assertEquals(10, uf.connectedComponentCount);
        uf.union(0, 1);
        assertEquals(true, uf.isConnected(0, 1));
        assertEquals(0, uf.find(1));
        assertEquals(0, uf.find(0));
        assertEquals(9, uf.connectedComponentCount);
        uf.union(0, 9);
        assertEquals(0, uf.find(9));
        assertEquals(8, uf.connectedComponentCount);
        assertEquals(true, uf.isConnected(9, 1));
    }

}
