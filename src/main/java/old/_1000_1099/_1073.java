package old._1000_1099;

import java.util.ArrayList;

/**  
 * @ClassName: _1073  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月5日  
 *  
 */
public class _1073 {

    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            ArrayList<Integer> list = new ArrayList<>();

            int                i1   = arr1.length - 1, i2 = arr2.length - 1, carry = 0, n1, n2, digit;

            while (true) {

                if (i1 == -1 && i2 == -1 && carry == 0) {
                    break;
                }

                n1    = i1 == -1 ? 0 : arr1[i1--];
                n2    = i2 == -1 ? 0 : arr2[i2--];

                digit = n1 + n2 + carry;

                if (digit == 3) {
                    carry = -1;
                    list.add(1);
                } else if (digit == 2) {
                    carry = -1;
                    list.add(0);
                } else if (digit == 1) {
                    carry = 0;
                    list.add(1);
                } else if (digit == 0) {
                    carry = 0;
                    list.add(0);
                } else if (digit == -1) {
                    carry = 1;
                    list.add(1);
                }
            }
            while (list.size() != 1 && list.get(list.size() - 1) == 0) {
                list.remove(list.size() - 1);
            }
            int[] ans = new int[list.size()];
            for (int i = list.size() - 1; i >= 0; --i) {
                ans[list.size() - i - 1] = list.get(i);
            }
            return ans;
        }
    }

}
