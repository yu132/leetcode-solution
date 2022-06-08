package redo.Util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 余定邦
 * @ClassName: Range
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月29日
 */
public class RangeUtil {

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

        public boolean isValueInRange(int value) {
            return start <= value && value <= end;
        }

        //可能有问题
        public boolean overlapStrong(Range other) {
            return (start <= other.start && other.start <= end)
                    || (other.start <= start && end <= other.end)
                    || (start <= other.end && other.end <= end);
        }
    }

    @Test
    public void test() {
        Range[] ranges = {new Range(0, 1), new Range(1, 10), new Range(5, 9), new Range(11, 12)};
        List<Range> newRange = mergeRange(ranges);
        assertEquals(2, newRange.size());
        assertEquals(0, newRange.get(0).start);
        assertEquals(10, newRange.get(0).end);

        assertEquals(11, newRange.get(1).start);
        assertEquals(12, newRange.get(1).end);
    }

}
