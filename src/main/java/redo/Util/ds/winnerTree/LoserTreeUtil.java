package redo.Util.ds.winnerTree;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: LoserTree  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月16日  
 *  
 */
public class LoserTreeUtil {

    /*
     * 稍微解释一下，由于每次比赛会干掉一个人，因此总共要进行n-1场比赛
     * tree[1:n]是败者树的部分，tree[0]是最终的赢家
     * 
     * values扩展1是为了提供一个最大值，其需要保证比任何值都大
     * 
     * 首先先向tree中填充最后一个位置的值n，values[n]=INT_MAX
     * 因此下面初始化中每次比较都是必败无疑的，除了最后一次比较
     * 
     * 因为每次比较都会失败，并且更新树，因此会渐渐的将n从树中删去，
     * 留下的就是正常的值，通过比较n-1次，最终剩下的那个就是这n个数中最大的胜家
     * 由于每次replay都会更新tree[0] = winner，因此只有最后一次生效
     * 即tree[0]为最大的那个值
     */

    // test by leetcode-1090
    static class LoserTree {

        int[] tree, values;
        Comparator<Integer> comparator;

        public LoserTree(int[] values) {
            this(values, Integer::compare);
        }

        public LoserTree(int[] values, Comparator<Integer> comparator) {
            int n = values.length;
            tree = new int[n];
            this.values = new int[n + 1];
            this.values[n] = Integer.MAX_VALUE;
            this.comparator = comparator;
            System.arraycopy(values, 0, this.values, 0, n);
            Arrays.fill(tree, n);
            for (int i = n - 1; i >= 0; --i) {
                replay(i);
            }
        }

        private void replay(int index) {
            int winner = index, parent = (index + tree.length) / 2;
            while (parent > 0) {
                if (comparator.compare(values[winner], values[tree[parent]]) < 0) {// 比不过
                    int temp = winner;
                    winner = tree[parent];
                    tree[parent] = temp;
                }
                parent /= 2;
            }
            tree[0] = winner;
        }

        void replayWinner(int val) {
            values[tree[0]] = val;
            replay(tree[0]);
        }

        int winner() {
            return values[tree[0]];
        }

        int winnerIndex() {
            return tree[0];
        }
    }



    @Test
    public void test() {
        LoserTree s = new LoserTree(new int[] {1, 2, 3, 4, 5, 6});
        Assert.assertEquals(6, s.winner());
        Assert.assertEquals(5, s.winnerIndex());

        s.replayWinner(0);

        Assert.assertEquals(5, s.winner());
        Assert.assertEquals(4, s.winnerIndex());

        s.replayWinner(0);

        Assert.assertEquals(4, s.winner());
        Assert.assertEquals(3, s.winnerIndex());
    }

    @Test
    public void test2() {
        LoserTree s = new LoserTree(new int[] {1, 2, 3, 4, 5, 6, 7});
        Assert.assertEquals(7, s.winner());
        Assert.assertEquals(6, s.winnerIndex());

        s.replayWinner(0);

        Assert.assertEquals(6, s.winner());
        Assert.assertEquals(5, s.winnerIndex());

        s.replayWinner(0);

        Assert.assertEquals(5, s.winner());
        Assert.assertEquals(4, s.winnerIndex());

        s.replayWinner(0);

        Assert.assertEquals(4, s.winner());
        Assert.assertEquals(3, s.winnerIndex());
    }

}
