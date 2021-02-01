package redo.p0800_0899;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P826  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P826 {

    static//

    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int n = difficulty.length, m = worker.length;

            SimpleIntArrayDeque mdeque = new SimpleIntArrayDeque(n);

            int[] sortedIndexes = indexSort(difficulty, profit);

            for (int i = 0; i < n; ++i) {
                int indexNow = sortedIndexes[i];
                while (!mdeque.isEmpty()) {
                    int indexOld = mdeque.peekLast();
                    if (difficulty[indexOld] >= difficulty[indexNow] && profit[indexOld] <= profit[indexNow]) {
                        mdeque.pollLast();
                    } else {
                        break;
                    }
                }
                mdeque.offerLast(indexNow);
            }

            Arrays.sort(worker);

            int ans = 0, second;

            for (int i = 0; i < m; ++i) {
                while ((second = mdeque.peekSecond()) != -1 && worker[i] >= difficulty[second]) {// 比第二个都大，那肯定选第二个
                    mdeque.pollFirst();
                }
                if (worker[i] >= difficulty[mdeque.peekFirst()]) {
                    ans += profit[mdeque.peekFirst()];
                }
            }

            return ans;
        }

        static int[] indexSort(int[] diff, int[] prof) {
            int[] sortedIndexes = new int[diff.length];
            Arrays.setAll(sortedIndexes, (x) -> x);
            sort(sortedIndexes, (i, j) -> {
                if (prof[i] == prof[j]) {
                    return Integer.compare(diff[j], diff[j]);
                }
                return Integer.compare(prof[i], prof[j]);
            });
            return sortedIndexes;
        }

        public static void sort(int[] arr, Comparator<Integer> comparator) {
            Integer[] copy = new Integer[arr.length];
            for (int i = 0; i < arr.length; ++i) {
                copy[i] = arr[i];
            }
            Arrays.sort(copy, comparator);
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = copy[i];
            }
        }

        static class SimpleIntArrayDeque {

            int start = 0, end = 0, deque[];

            public SimpleIntArrayDeque(int len) {
                super();
                this.deque = new int[len];
            }

            public void offerLast(int num) {
                deque[end++] = num;
            }

            public int pollLast() {
                return deque[--end];
            }

            public int peekLast() {
                return deque[end - 1];
            }

            public int pollFirst() {
                return deque[start++];
            }

            public int peekFirst() {
                return deque[start];
            }

            public int peekSecond() {
                if (start + 1 >= end) {
                    return -1;
                }
                return deque[start + 1];
            }

            public boolean isEmpty() {
                return start == end;
            }

            public int size() {
                return end - start;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(100,
            s.maxProfitAssignment(new int[] {2, 4, 6, 8, 10}, new int[] {10, 20, 30, 40, 50}, new int[] {4, 5, 6, 7}));

        Assert.assertEquals(324, s.maxProfitAssignment(new int[] {68, 35, 52, 47, 86}, new int[] {67, 17, 1, 81, 3},
            new int[] {92, 10, 85, 84, 82}));
    }
}
