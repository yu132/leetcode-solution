package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1385  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1385 {

    static//

    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Range[] ranges = new Range[arr2.length];
            for (int i = 0; i < arr2.length; ++i) {
                ranges[i] = new Range(arr2[i] - d, arr2[i] + d);
            }
            List<Range> mergedRange = mergeRange(ranges);
            int count = 0;

            outer:
            for (int num : arr1) {
                for (Range range : mergedRange) {
                    if (range.in(num)) {
                        continue outer;
                    }
                }
                ++count;
            }
            return count;
        }

        public static List<Range> mergeRange(Range[] ranges) {
            if (ranges.length == 0) {
                return Collections.emptyList();
            }
            Arrays.sort(ranges, (a, b) -> Integer.compare(a.start, b.start));
            List<Range> ans = new ArrayList<>();
            Range now = ranges[0];

            for (int index = 1; index < ranges.length; ++index) {
                if (now.end >= ranges[index].start) {
                    now = new Range(now.start, Math.max(now.end, ranges[index].end));
                } else {
                    ans.add(now);
                    now = ranges[index];
                }
            }

            ans.add(now);

            return ans;
        }

        static class Range {
            int start;
            int end;

            Range(int start, int end) {
                super();
                this.start = start;
                this.end = end;
            }

            public boolean in(int value) {
                return start <= value && value <= end;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.findTheDistanceValue(new int[] {4, 5, 8}, new int[] {10, 9, 1, 8}, 2));
        Assert.assertEquals(2, s.findTheDistanceValue(new int[] {1, 4, 2, 3}, new int[] {-4, -3, 6, 10, 20, 30}, 3));
        Assert.assertEquals(1, s.findTheDistanceValue(new int[] {2, 1, 100, 3}, new int[] {-5, -2, 10, -3, 7}, 6));
    }

}
