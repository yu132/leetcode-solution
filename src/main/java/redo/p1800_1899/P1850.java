package redo.p1800_1899;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P1850 {

    class Solution {
        public int getMinSwaps(String num, int k) {
            int[] nums = new int[num.length()];
            Arrays.setAll(nums, x -> num.charAt(x) - '0');
            for (int i = 0; i < k; ++i) {
                nextPermutation(nums);
            }
            return new CountReverseUseMergeSort().reversePairs(indexes(num, nums));
        }

        int[] indexes(String num, int[] nums) {
            LinkedListMap<Integer, Integer> map = new LinkedListMap<>();
            for (int i = 0; i < num.length(); ++i) {
                map.addLast(num.charAt(i) - '0', i);
            }
            int[] indexes = new int[nums.length];
            for (int i = 0; i < num.length(); ++i) {
                indexes[i] = map.removeFirst(nums[i]);
            }
            return indexes;
        }

        class LinkedListMap<K, E> {

            Map<K, LinkedList<E>> map = new HashMap<>();

            public void addFirst(K key, E element) {
                get(key).addFirst(element);
            }

            public void addLast(K key, E element) {
                get(key).addLast(element);
            }

            public E removeFirst(K key) {
                return get(key).removeFirst();
            }

            public E removeLast(K key) {
                return get(key).removeLast();
            }

            public void remove(K key, E element) {
                get(key).remove(element);
            }

            public LinkedList<E> get(K key) {
                return map.computeIfAbsent(key, (x) -> new LinkedList<>());
            }

        }

        class CountReverseUseMergeSort {

            int ans;

            public int reversePairs(int[] nums) {
                ans = 0;
                mergerSort(nums, 0, nums.length);
                return ans;
            }

            void mergerSort(int[] nums, int low, int high) {
                if (low >= high - 1) {
                    return;
                }

                int mid = (low + high) >>> 1;

                mergerSort(nums, low, mid);
                mergerSort(nums, mid, high);

                int[] copy = Arrays.copyOfRange(nums, low, mid);

                int index1 = 0, index2 = mid, index = low;

                while (index1 != copy.length && index2 != high) {
                    if (copy[index1] <= nums[index2]) {
                        nums[index++] = copy[index1++];
                    } else {
                        ans += copy.length - index1;
                        nums[index++] = nums[index2++];
                    }
                }

                while (index1 != copy.length) {
                    nums[index++] = copy[index1++];
                }

                return;
            }
        }

        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 2; i >= 0; --i) {
                if (nums[i] >= nums[i + 1]) {
                    continue;
                } else {
                    int index = i + 1;
                    while (index + 1 < nums.length
                            && nums[index + 1] > nums[i]) {
                        ++index;
                    }
                    swap(nums, i, index);
                    reverse(nums, i + 1, nums.length - 1);
                    return;
                }
            }
            reverse(nums, 0, nums.length - 1);
        }

        void reverse(int[] nums, int low, int high) {
            for (; low < high; ++low, --high) {
                swap(nums, low, high);
            }
        }

        void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;

        }
    }

}
