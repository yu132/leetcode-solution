package redo.p1500_1599;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1560  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1560 {

    static//

    class Solution {
        public List<Integer> mostVisited(int n, int[] rounds) {
            if (rounds[0] <= rounds[rounds.length - 1]) {
                return range(rounds[0], rounds[rounds.length - 1] + 1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.addAll(range(1, rounds[rounds.length - 1] + 1));
                list.addAll(range(rounds[0], n + 1));
                return list;
            }
        }

        public static List<Integer> range(int start, int end) {
            List<Integer> list = new ArrayList<>(end - start);
            for (int i = start; i < end; ++i) {
                list.add(i);
            }
            return list;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(1, 2), s.mostVisited(4, new int[] {1, 3, 1, 2}));
        Assert.assertEquals(Arrays.asList(2), s.mostVisited(2, new int[] {2, 1, 2, 1, 2, 1, 2, 1, 2}));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), s.mostVisited(4, new int[] {1, 3, 5, 7}));
        Assert.assertEquals(Arrays.asList(1, 7, 8), s.mostVisited(8, new int[] {7, 1}));

    }



}
