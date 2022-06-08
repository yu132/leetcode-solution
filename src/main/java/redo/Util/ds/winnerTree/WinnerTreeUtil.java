package redo.Util.ds.winnerTree;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: WinnerTree  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月16日  
 *  
 */
public class WinnerTreeUtil {

    static class IntWinnerTree {
        int n, size, tree[];
        Comparator<Integer> comparator;

        IntWinnerTree(int[] values) {
            this(values, Integer::compare);
        }

        IntWinnerTree(int[] values, Comparator<Integer> comparator) {
            size = values.length;
            this.comparator = comparator;
            if (size % 2 == 0) {
                tree = new int[size * 2 - 1];
                n = size;
            } else {
                tree = new int[size * 2];
                n = size - 1;
            }
            System.arraycopy(values, 0, tree, size - 1, size);

            for (int index = n - 2; index >= (n - 2) >> 1; --index) {
                int child1 = (index << 1) + 1, child2 = (index << 1) + 2;
                tree[index] = comparator.compare(tree[child1], tree[child2]) >= 0 ? child1 : child2;
            }

            for (int index = ((n - 2) >> 1) - 1; index >= 0; --index) {
                int child1 = tree[(index << 1) + 1], child2 = tree[(index << 1) + 2];
                tree[index] = comparator.compare(tree[child1], tree[child2]) >= 0 ? child1 : child2;
            }
        }

        public int winnerIndex() {
            return tree[0] - n + 1;
        }

        public int winner() {
            return tree[tree[0]];
        }

        public void replay(int index, int val) {
            index = n - 1 + index;
            tree[index] = val;
            index = (index - 1) >> 1;

            int child1 = (index << 1) + 1, child2 = (index << 1) + 2;
            tree[index] = comparator.compare(tree[child1], tree[child2]) >= 0 ? child1 : child2;

            do {

                index = (index - 1) >> 1;

                child1 = tree[(index << 1) + 1];
                child2 = tree[(index << 1) + 2];

                tree[index] = comparator.compare(tree[child1], tree[child2]) >= 0 ? child1 : child2;

            } while (index != 0);
        }
    }



    @Test
    public void test() {
        int[] values = {1, 2, 3, 4, 5, 6};
        IntWinnerTree s = new IntWinnerTree(values);
        Assert.assertEquals(6, s.winner());
        Assert.assertEquals(5, s.winnerIndex());

        s.replay(0, 7);

        Assert.assertEquals(7, s.winner());
        Assert.assertEquals(0, s.winnerIndex());
    }

}
