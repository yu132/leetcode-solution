package redo.p1400_1499;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1488  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1488 {

    static//

    class Solution {
        public int[] avoidFlood(int[] rains) {
            Map<Integer, Integer> fullLake = new HashMap<>();

            int notRainIndex = 0, notRain[] = new int[rains.length];

            int[] next = new int[rains.length];

            Arrays.setAll(next, (x) -> x);

            for (int i = 0; i < rains.length; ++i) {
                if (rains[i] == 0) {
                    notRain[notRainIndex] = i;
                    next[notRainIndex] = notRainIndex;
                    ++notRainIndex;
                } else {
                    if (fullLake.containsKey(rains[i])) {
                        int index = fullLake.get(rains[i]);
                        int first = lowerBound(notRain, index, 0, notRainIndex);
                        if (first == notRainIndex || (first = findNext(first, next) - 1) == notRainIndex) {
                            return new int[0];
                        }
                        rains[notRain[first]] = rains[i];
                    }
                    fullLake.put(rains[i], i);
                    rains[i] = -1;
                }
            }

            for (int i = 0; i < notRainIndex; ++i) {
                if (next[i] == i) {
                    rains[notRain[i]] = 1;
                }
            }

            return rains;
        }

        public int lowerBound(int[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        public int findNext(int nextIndex, int[] next) {
            if (next[nextIndex] == nextIndex) {
                next[nextIndex] = nextIndex + 1;
                return nextIndex + 1;
            } else {
                return next[nextIndex] = findNext(next[nextIndex], next);
            }
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertArrayEquals(new int[] {-1, -1, -1, -1}, s.avoidFlood(new int[] {1, 2, 3, 4}));
        // Assert.assertArrayEquals(new int[] {-1, -1, 2, 1, -1, -1}, s.avoidFlood(new int[] {1, 2, 0, 0, 2, 1}));
        Assert.assertArrayEquals(new int[] {}, s.avoidFlood(new int[] {1, 2, 0, 1, 2}));
        Assert.assertArrayEquals(new int[] {-1, 69, 1, 1, -1}, s.avoidFlood(new int[] {69, 0, 0, 0, 69}));
        Assert.assertArrayEquals(new int[] {}, s.avoidFlood(new int[] {10, 20, 20}));
        Assert.assertArrayEquals(new int[] {}, s.avoidFlood(new int[] {0, 1, 1}));
        Assert.assertArrayEquals(new int[] {1, -1, 1, -1, 2, -1, -1}, s.avoidFlood(new int[] {0, 1, 0, 2, 0, 1, 2}));
    }

}
