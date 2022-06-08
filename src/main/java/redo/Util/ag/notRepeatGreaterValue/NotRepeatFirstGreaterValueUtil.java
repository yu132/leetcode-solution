package redo.Util.ag.notRepeatGreaterValue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Test;

/**  
 * @ClassName: NotRepeatFirstGreaterValueUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class NotRepeatFirstGreaterValueUtil {

    // 能在有序的nums中多次查询不重复的第一个大于等于当前query的数
    // 如果不要等于，那么要用upperBound进行二分查找
    static class NotRepeatFirstGreaterValue {

        int len, nums[], next[];

        public NotRepeatFirstGreaterValue(int len) {
            len = 0;
            nums = new int[len];
            init(len);
        }

        public NotRepeatFirstGreaterValue(int[] nums) {
            len = nums.length;
            this.nums = nums;
            init(len);
        }

        private void init(int len) {
            next = new int[len + 1];
            this.len = len;

            // 在没有被使用的情况下，自己的下一个可用就是自己
            Arrays.setAll(next, (x) -> x);
        }

        public void offer(int num) {
            nums[len++] = num;
        }

        public int query(int queryNum) {
            int index = lowerBound(nums, queryNum, 0, len);// 寻找第一个大于等于本查询的数
            int firstAvailable = findNext(index, next);
            if (firstAvailable == -1) {
                return -1;
            }
            return nums[firstAvailable];
        }

        // 返回当前可用的第一个数的下标，由于下面这个方法返回第二个数的下标，因此要减一
        // 如果没有更大的数，则返回-1
        private int findNext(int nextIndex, int[] next) {
            int ans = next(nextIndex, next) - 1;
            if (ans == len) {
                return -1;
            }
            return ans;
        }

        // 选择下一个可以使用的数的下标
        // 由于需要向前更新，因此最后返回的数是当前可选的数的下一个数的下标
        // 使用了路径压缩的思想，保证能够快速的找到下一个数，而无需线性遍历
        private int next(int nextIndex, int[] next) {
            if (next[nextIndex] == nextIndex) {
                next[nextIndex] = nextIndex + 1;
                return nextIndex + 1;
            } else {
                return next[nextIndex] = next(next[nextIndex], next);
            }
        }

        private int lowerBound(int[] nums, int target, int start, int end) {
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
    }

    @Test
    public void test() {
        NotRepeatFirstGreaterValue helper = new NotRepeatFirstGreaterValue(new int[] {1, 2, 3, 4, 5, 6});

        assertEquals(2, helper.query(2));
        assertEquals(3, helper.query(2));
        assertEquals(4, helper.query(2));
        assertEquals(5, helper.query(2));
        assertEquals(6, helper.query(2));
        assertEquals(-1, helper.query(2));
    }

    @Test
    public void test2() {
        NotRepeatFirstGreaterValue helper =
            new NotRepeatFirstGreaterValue(new int[] {1, 2, 3, 4, 5, 6, 101, 102, 102, 102, 205, 206, 207, 1000});

        assertEquals(2, helper.query(2));
        assertEquals(3, helper.query(2));
        assertEquals(5, helper.query(5));
        assertEquals(6, helper.query(6));
        assertEquals(4, helper.query(2));
        assertEquals(101, helper.query(2));
        assertEquals(102, helper.query(101));
        assertEquals(102, helper.query(101));
        assertEquals(102, helper.query(101));
        assertEquals(205, helper.query(101));
        assertEquals(206, helper.query(2));
        assertEquals(1, helper.query(1));
        assertEquals(207, helper.query(1));
        assertEquals(1000, helper.query(1));
        assertEquals(-1, helper.query(1));
    }

}
