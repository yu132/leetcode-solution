package redo.Util.counter;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author 余定邦
 * @ClassName: NumCounter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月29日
 */
public class NumCounterUtil {

    //求数组中，比当前元素更小的左右最接近的index
    class LitterAroundUtil {
        int[] left;//该index中，比num[index]更小的左侧第一个元素的index
        int[] right;//该index中，比num[index]更小或相等的的右侧第一个元素的index

        public LitterAroundUtil(int[] arr) {
            int n = arr.length;
            left = new int[n];
            right = new int[n];
            Arrays.fill(right, -1);
            Arrays.fill(right, n);
            LinkedList<Integer> mq = new LinkedList<>();
            for (int i = 0; i < arr.length; ++i) {
                while (!mq.isEmpty() && arr[mq.peek()] >= arr[i]) {
                    right[mq.poll()] = i;
                }
                if (!mq.isEmpty()) {
                    left[i] = mq.peek();
                }
                mq.push(i);
            }
        }
    }

    int[] count(int[] nums, int start, int end) {
        int[] count = new int[end - start];
        for (int num : nums) {
            ++count[num - start];
        }
        return count;
    }

    // 前缀和 sum(0 to i)=prefix[i+1];
    int[] prefix(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix;
    }

    int sumRange(int[] prefix, int from, int to) {
        return prefix[to] - prefix[from];
    }

    int[][] prefix2D(int[][] nums) {
        int[][] prefix = new int[nums.length + 1][nums[0].length + 1];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums[0].length; ++j) {
                prefix[i + 1][j + 1] = nums[i][j] + prefix[i][j + 1]
                        + prefix[i + 1][j] - prefix[i][j];
            }
        }
        return prefix;
    }

    // x2和y2是包括的右下角边界
    int sum2DRange(int x1, int y1, int x2, int y2, int[][] prefix) {
        return prefix[x2 + 1][y2 + 1] - prefix[x2 + 1][y1] - prefix[x1][y2 + 1]
                + prefix[x1][y1];
    }

    // 后缀和 sum(i to len)=suffix[i];
    int[] suffix(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; --i) {
            prefix[i] = prefix[i + 1] + nums[i];
        }
        return prefix;
    }

    void countRowAndColumn(int[][] matrix, int[] row, int[] col) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                row[i] += matrix[i][j];
                col[j] += matrix[i][j];
            }
        }
    }

    //获取从0到i的最大值
    int[] maxFromStartToI(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            ans[i] = Math.max(ans[i - 1], nums[i]);
        }
        return ans;
    }

    //获取从i到n-1的最小值
    int[] minFromIToEnd(int[] nums) {
        int[] ans = new int[nums.length];
        ans[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            ans[i] = Math.min(ans[i + 1], nums[i]);
        }
        return ans;
    }

}
