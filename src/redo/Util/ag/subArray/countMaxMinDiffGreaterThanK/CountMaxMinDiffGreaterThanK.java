package redo.Util.ag.subArray.countMaxMinDiffGreaterThanK;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: CountMaxMinDiffGreaterThanK  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月30日  
 *  
 */
public class CountMaxMinDiffGreaterThanK {

    static int helper(int[] arr, int num) {
        Deque<Integer> max = new LinkedList<>(), min = new LinkedList<>();

        int ans = 0;

        for (int i = 0, j = 0; i < arr.length && j < arr.length; ++i) {
            while (j < arr.length) {
                while (!max.isEmpty() && arr[max.peekLast()] <= arr[j]) {
                    max.pollLast();
                }
                max.offerLast(j);
                while (!min.isEmpty() && arr[min.peekLast()] >= arr[j]) {
                    min.pollLast();
                }
                min.offerLast(j);
                if (arr[max.peekFirst()] - arr[min.peekFirst()] > num) {
                    ans += arr.length - j;
                    break;
                }
                ++j;
            }

            if (max.peekFirst() == i) {
                max.removeFirst();
            }

            if (min.peekFirst() == i) {
                min.removeFirst();
            }
        }

        return ans;
    }

}
