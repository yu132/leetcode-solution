package redo.p1600_1699;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1686  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1686 {


    class Solution {
        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            Data[] datas = new Data[aliceValues.length];
            for (int i = 0; i < datas.length; ++i) {
                datas[i] = new Data(aliceValues[i] + bobValues[i], i);
            }
            Arrays.sort(datas, (a, b) -> Integer.compare(b.diff, a.diff));
            int aliceValue = 0, bobValue = 0;
            boolean alicePick = true;
            for (int i = 0; i < datas.length; ++i) {
                if (alicePick) {
                    aliceValue += aliceValues[datas[i].index];
                } else {
                    bobValue += bobValues[datas[i].index];
                }
                alicePick = !alicePick;
            }
            return Integer.compare(aliceValue, bobValue);
        }

        class Data {
            int diff;
            int index;

            public Data(int diff, int index) {
                super();
                this.diff = diff;
                this.index = index;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.stoneGameVI(new int[] {1, 3}, new int[] {2, 1}));
        Assert.assertEquals(0, s.stoneGameVI(new int[] {1, 2}, new int[] {3, 1}));
        Assert.assertEquals(-1, s.stoneGameVI(new int[] {2, 4, 3}, new int[] {1, 6, 7}));
        Assert.assertEquals(1, s.stoneGameVI(new int[] {9, 8, 3, 8}, new int[] {10, 6, 9, 5}));
    }

}
