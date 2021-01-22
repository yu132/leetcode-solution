package redo.p0900_0999;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P957  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P957 {

    class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {

            int mask = 0x7E;// 01111110
            int num = 0;
            for (int i = 0; i < cells.length; ++i) {
                num |= cells[i] << (cells.length - i - 1);
            }

            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();

            set.add(num);
            list.add(num);

            while (true) {
                num = (~((num >> 1) ^ (num << 1))) & mask;
                --N;
                if (N == 0) {
                    return toAns(num);
                }
                if (set.contains(num)) {
                    break;
                }
                set.add(num);
                list.add(num);
            }

            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i) == num) {
                    int len = list.size() - i;
                    N %= len;
                    return toAns(list.get(i + N));
                }
            }

            throw new RuntimeException("unreachable");
        }

        public int[] toAns(int num) {
            int[] arr = new int[8];
            for (int i = 0; i < arr.length; ++i) {
                arr[arr.length - 1 - i] = num & 1;
                num >>>= 1;
            }
            return arr;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {0, 0, 1, 1, 0, 0, 0, 0},
            s.prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 7));

        Assert.assertArrayEquals(new int[] {0, 0, 1, 1, 1, 1, 1, 0},
            s.prisonAfterNDays(new int[] {1, 0, 0, 1, 0, 0, 1, 0}, 1000000000));

        Assert.assertArrayEquals(new int[] {0, 0, 0, 1, 1, 0, 0, 0},
            s.prisonAfterNDays(new int[] {0, 0, 1, 1, 1, 1, 0, 0}, 8));
    }

}
