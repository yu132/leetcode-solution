package redo.p2000_2099;

import java.util.*;
import java.util.function.Function;

public class P2099 {

    class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            PriorityQueue<IntWithIndex> pq = new PriorityQueue<>();
            for (int i = 0; i < nums.length; ++i) {
                if (pq.size() < k) {
                    pq.add(new IntWithIndex(nums[i], i));
                } else {
                    if (pq.peek().value < nums[i]) {
                        pq.poll();
                        pq.add(new IntWithIndex(nums[i], i));
                    }
                }
            }
            List<IntWithIndex> list = new ArrayList<>(pq);
            Collections.sort(list, Comparator.comparingInt(a -> a.index));
            return toIntArray(list, a -> a.value);
        }

        <E> int[] toIntArray(List<E> list, Function<E, Integer> valueTaker) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = valueTaker.apply(list.get(i));
            }
            return arr;
        }

        class IntWithIndex implements Comparable<IntWithIndex> {
            int value;
            int index;

            public IntWithIndex(int value, int index) {
                this.value = value;
                this.index = index;
            }

            @Override
            public int compareTo(IntWithIndex o) {
                return Integer.compare(value, o.value);
            }
        }

    }

}
