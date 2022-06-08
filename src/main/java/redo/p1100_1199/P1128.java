package redo.p1100_1199;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1128  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class P1128 {

    static//

    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            Counter<String> counter = new Counter<>();
            Counter<Integer> counterSame = new Counter<>();

            for (int[] dominoe : dominoes) {
                if (dominoe[0] != dominoe[1]) {
                    counter.plus1(dominoe[0] + " " + dominoe[1]);
                    counter.plus1(dominoe[1] + " " + dominoe[0]);
                } else {
                    counterSame.plus1(dominoe[0]);
                }
            }

            int sum = 0;
            for (IntValue intValue : counter.counter.values()) {
                int n = intValue.value;
                sum += n * (n - 1) / 2;
            }

            int sum1 = 0;
            for (IntValue intValue : counterSame.counter.values()) {
                int n = intValue.value;
                sum1 += n * (n - 1) / 2;
            }

            return sum / 2 + sum1;
        }

        static class Counter<K> {

            Map<K, IntValue> counter = new HashMap<>();

            public final static IntValue NUM_0 = new IntValue();

            public void plus1(K key) {
                ++counter.computeIfAbsent(key, (x) -> new IntValue()).value;
            }

            public int get(K key) {
                return counter.getOrDefault(key, NUM_0).value;
            }
        }

        static class IntValue {
            int value = 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.numEquivDominoPairs(Arrs.build2D("[[1,2],[2,1],[3,4],[5,6]]")));
        Assert.assertEquals(3, s.numEquivDominoPairs(Arrs.build2D("[[1,2],[2,1],[1,2]]")));
        Assert.assertEquals(3, s.numEquivDominoPairs(Arrs.build2D("[[1,2],[1,2],[1,1],[1,2],[2,2]]")));
        Assert.assertEquals(3, s.numEquivDominoPairs(Arrs.build2D("[[1,1],[1,1],[1,1]]")));
    }

}
