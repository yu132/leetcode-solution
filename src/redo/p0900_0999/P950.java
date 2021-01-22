package redo.p0900_0999;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P950  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P950 {

    /*
     * 1 _ 2 _ 3 _ 4 _ 5 _ 6 _ 7 _ 8 _ 9 _ 10 _
     *   11  _   12  _   13  _   14  _   15
     *       16      _       17      _        18
     *               _               19
     *               20
     *               
     * 1 _ 2 _ 3 _ 4 _ 5 _ 6 _ 7 _ 8 _ 9 _ 10 _ 11
     *   _   12  _   13  _   14  _   15  _    16
     *   _       17      _       18      _
     *   19              _              20
     *                   21
     *                   
     * 1 _ 2 _ 3 _ 4
     *   _   5   _
     *   6       _
     *           7
    
     *   
     * 1 _ 2 _ 3 _ 4 _
     *   5   _   6   _
     *       7       _
     *               8
     * 
     */

    static//

    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            int[] ans = new int[deck.length];
            Arrays.sort(deck);
            int index = 0, in = 0;
            NextHelper nextHelper = new NextHelper(deck.length);
            while (true) {
                nextHelper.use(in);
                ans[in] = deck[index++];
                if (index == deck.length) {
                    break;
                }
                in = nextHelper.findNext((in + 1) % deck.length);
                in = nextHelper.findNext((in + 1) % deck.length);
            }
            return ans;
        }

        // 循环next，注意调用use次数超过n次后不能再调用findNext，否则会出现无限循环
        static class NextHelper {
            int[] next;

            NextHelper(int len) {
                next = new int[len];
                Arrays.setAll(next, (x) -> x);
            }

            int findNext(int index) {
                if (next[index] == index) {
                    return index;
                } else {
                    return next[index] = findNext(next[index]);
                }
            }

            void use(int index) {
                next[index] = (index + 1 >= next.length ? 0 : index + 1);
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 13, 3, 11, 5, 17, 7},
            s.deckRevealedIncreasing(new int[] {17, 13, 11, 2, 3, 5, 7}));
        Assert.assertArrayEquals(new int[] {1, 11, 2, 16, 3, 12, 4, 20, 5, 13, 6, 17, 7, 14, 8, 19, 9, 15, 10, 18}, s
            .deckRevealedIncreasing(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}));
    }

}
