package redo.p1800_1899;

import java.util.Arrays;
import java.util.LinkedList;

public class P1856 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int maxSumMinProduct(int[] nums) {
            LitterAroundUtil helper = new LitterAroundUtil(nums);
            long[] prefix = prefix(nums);

            long ans = 0;

            for (int i = 0; i < nums.length; ++i) {
                ans = Math.max(ans, sumRange(prefix, helper.left[i], helper.right[i] + 1) * nums[i]);
            }

            return (int) (ans % MOD);
        }

        // 前缀和 sum(0 to i)=prefix[i+1];
        long[] prefix(int[] nums) {
            long[] prefix = new long[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }

        long sumRange(long[] prefix, int from, int to) {
            return prefix[to] - prefix[from];
        }

        //求数组中，比当前元素更小的左右最接近的index
        class LitterAroundUtil {
            int[] left;//该index中，比num[index]更小的左侧第一个元素的index
            int[] right;//该index中，比num[index]更小或相等的的右侧第一个元素的index

            public LitterAroundUtil(int[] arr) {
                int n = arr.length;
                left = new int[n];
                right = new int[n];
                Arrays.fill(right, 0);
                Arrays.fill(right, n - 1);
                LinkedList<Integer> mq = new LinkedList<>();
                for (int i = 0; i < arr.length; ++i) {
                    while (!mq.isEmpty() && arr[mq.peek()] >= arr[i]) {
                        right[mq.poll()] = i - 1;
                    }
                    if (!mq.isEmpty()) {
                        left[i] = mq.peek() + 1;
                    }
                    mq.push(i);
                }
            }
        }

    }

}
