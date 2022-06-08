package redo.p1300_1399;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1331  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1331 {

    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int[] copy = Arrays.copyOf(arr, arr.length);
            Arrays.sort(copy);
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : copy) {
                map.putIfAbsent(num, map.size() + 1);
            }
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = map.get(arr[i]);
            }
            return arr;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {4, 1, 2, 3}, s.arrayRankTransform(new int[] {40, 10, 20, 30}));
        Assert.assertArrayEquals(new int[] {1, 1, 1}, s.arrayRankTransform(new int[] {100, 100, 100}));
        Assert.assertArrayEquals(new int[] {5, 3, 4, 2, 8, 6, 7, 1, 3},
            s.arrayRankTransform(new int[] {37, 12, 28, 9, 100, 56, 80, 5, 12}));

    }

}
