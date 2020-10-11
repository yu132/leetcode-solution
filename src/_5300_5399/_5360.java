package _5300_5399;

import java.util.Arrays;

/**  
 * @ClassName: _5360  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月5日  
 *  
 */
public class _5360 {

    class Solution {
        public int countLargestGroup(int n) {
            int[] counter = new int[37];
            for (int i = 1; i <= n; ++i) {
                ++counter[sum(i)];
            }
            System.out.println(Arrays.toString(counter));
            int max = counter[0], count = 1;
            for (int i = 1; i < counter.length; ++i) {
                if (counter[i] == max) {
                    ++count;
                } else if (counter[i] > max) {
                    max   = counter[i];
                    count = 1;
                }
            }
            return count;
        }

        public int sum(int n) {
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n   /= 10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        new _5360().new Solution().countLargestGroup(3853);
    }
}
