package _1100_1199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: _1104  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月6日  
 *  
 */
public class _1104 {

    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            List<Integer> ans = new ArrayList<>();
            while (label != 0) {
                ans.add(label);
                label /= 2;
                int ub = toUpper2N(label + 1);
                label = ub + ub / 2 - 1 - label;
            }
            Collections.reverse(ans);
            return ans;
        }

        public int toUpper2N(int num) {

            int value = num - 1;

            value |= (value >>> 1);
            value |= (value >>> 2);
            value |= (value >>> 4);
            value |= (value >>> 8);
            value |= (value >>> 16);
            value++;

            if (value < 0)// 0x80000000 -> Integer.MIN_VALUE
                value >>>= 1;// 0x40000000 -> 2^30

            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1104().new Solution().pathInZigZagTree(26));
    }

}
