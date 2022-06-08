package redo.p2100_2199;

import java.util.LinkedList;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P2104 {

    class Solution {
        public long subArrayRanges(int[] nums) {
            int n = nums.length;
            int[] minLeft = new int[n], minRight = new int[n], maxLeft = new int[n], maxRight = new int[n];

            MonotonicQueueTemplate<Integer> monoQueLittle = new MonotonicQueueTemplate<>(),
                    monoQueGreater = new MonotonicQueueTemplate<>();

            for (int i = 0; i < n; ++i) {
                final int finalI = i;
                monoQueLittle.removeAndAddLast(i, (o, nI) -> nums[nI] <= nums[o], x -> minRight[x] = finalI);
                monoQueGreater.removeAndAddLast(i, (o, nI) -> nums[nI] >= nums[o], x -> maxRight[x] = finalI);
            }

            monoQueLittle.removeLastUtilEmpty(x -> minRight[x] = n);
            monoQueGreater.removeLastUtilEmpty(x -> maxRight[x] = n);

            for (int i = n - 1; i >= 0; --i) {
                final int finalI = i;
                monoQueLittle.removeAndAddLast(i, (o, nI) -> nums[nI] < nums[o], x -> minLeft[x] = finalI);
                monoQueGreater.removeAndAddLast(i, (o, nI) -> nums[nI] > nums[o], x -> maxLeft[x] = finalI);
            }

            monoQueLittle.removeLastUtilEmpty(x -> minLeft[x] = -1);
            monoQueGreater.removeLastUtilEmpty(x -> maxLeft[x] = -1);

            long ans = 0;

            for (int i = 0; i < n; ++i) {
                ans += (long) ((i - maxLeft[i]) * (maxRight[i] - i) - (i - minLeft[i]) * (minRight[i] - i)) * nums[i];
            }

            return ans;
        }

        public class MonotonicQueueTemplate<E> {

            public LinkedList<E> list = new LinkedList<>();

            public void removeAndAddLast(E val, BiPredicate<E, E> removeWhenOldAndNew, Consumer<E> handleRemove) {
                while (!list.isEmpty() && removeWhenOldAndNew.test(list.getLast(), val)) {
                    handleRemove.accept(list.removeLast());
                }
                list.addLast(val);
            }

            public void removeLastUtilEmpty(Consumer<E> handleRemove) {
                while (!list.isEmpty()) {
                    handleRemove.accept(list.removeLast());
                }
            }

        }
    }


    public static void main(String[] args) {
        new P2104().new Solution().subArrayRanges(new int[]{4, -2, -3, 4, 1});
    }
}
