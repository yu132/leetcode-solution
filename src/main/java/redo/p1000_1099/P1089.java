package redo.p1000_1099;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1089  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1089 {

    class Solution {
        public void duplicateZeros(int[] arr) {
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < arr.length; ++i) {
                if (queue.isEmpty()) {
                    if (arr[i] != 0) {
                        continue;
                    } else {
                        queue.offer(0);
                    }
                } else {
                    if (arr[i] != 0) {
                        queue.offer(arr[i]);
                    } else {
                        queue.offer(0);
                        queue.offer(0);
                    }
                    arr[i] = queue.poll();
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        s.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[] {1, 0, 0, 2, 3, 0, 0, 4}, arr);

        arr = new int[] {1, 2, 3};
        s.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[] {1, 2, 3}, arr);
    }

}
