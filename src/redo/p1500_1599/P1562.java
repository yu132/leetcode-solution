package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1562  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1562 {


    class Solution {
        public int findLatestStep(int[] arr, int m) {
            int[][] endPoints = new int[arr.length + 1][2];

            int countMLen = 0, ans = -1;

            for (int i = 0; i < arr.length; ++i) {
                int left = arr[i], right = arr[i];
                if (arr[i] > 1 && endPoints[left - 1][1] != 0) {
                    left = endPoints[left - 1][0];
                    int leftLen = endPoints[left][1] - endPoints[left][0] + 1;
                    if (leftLen == m) {
                        --countMLen;
                    }
                }

                if (arr[i] < arr.length && endPoints[right + 1][0] != 0) {
                    right = endPoints[right + 1][1];
                    int rightLen = endPoints[right][1] - endPoints[right][0] + 1;
                    if (rightLen == m) {
                        --countMLen;
                    }
                }

                int length = right - left + 1;

                if (length == m) {
                    ++countMLen;
                }

                if (countMLen > 0) {
                    ans = i + 1;
                }

                endPoints[left][0] = endPoints[right][0] = left;
                endPoints[left][1] = endPoints[right][1] = right;
            }

            return ans;
        }
    }


    // static//
    //
    // class Solution {
    // public int findLatestStep(int[] arr, int m) {
    // if (m == arr.length) {
    // return m;
    // }
    // Map<Range, Range> rangeTree = new TreeMap<>((a, b) -> {
    // if (a.start >= b.end) {
    // return 1;
    // } else if (b.start >= a.end) {
    // return -1;
    // } else {
    // return 0;
    // }
    // });
    // Range allRange = new Range(0, arr.length);
    // rangeTree.put(allRange, allRange);
    // for (int i = arr.length - 1; i >= 0; --i) {
    // Range r = rangeTree.remove(new Range(arr[i] - 1, arr[i]));
    // int left = arr[i] - r.start - 1, right = r.end - arr[i];
    // if (left == m || right == m) {
    // return i;
    // }
    // Range leftRange = new Range(r.start, arr[i] - 1);
    // Range rightRange = new Range(arr[i], r.end);
    // rangeTree.put(leftRange, leftRange);
    // rangeTree.put(rightRange, rightRange);
    // }
    // return -1;
    // }
    //
    // static class Range {
    // int start;
    // int end;
    //
    // Range(int start, int end) {
    // super();
    // this.start = start;
    // this.end = end;
    // }
    //
    // public boolean isValueInRange(int value) {
    // return start <= value && value <= end;
    // }
    //
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.findLatestStep(new int[] {3, 5, 1, 2, 4}, 1));
        Assert.assertEquals(-1, s.findLatestStep(new int[] {3, 1, 5, 4, 2}, 2));
        Assert.assertEquals(1, s.findLatestStep(new int[] {1}, 1));
        Assert.assertEquals(2, s.findLatestStep(new int[] {2, 1}, 2));
    }
}
