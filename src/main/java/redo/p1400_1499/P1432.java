package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1432  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1432 {

    class Solution {
        public int maxDiff(int num) {
            String str = String.valueOf(num);
            char[] max = str.toCharArray(), min = str.toCharArray();

            if (max[0] == '9') {
                if (max.length > 1) {
                    for (int i = 1; i < max.length; ++i) {
                        if (max[i] != '9') {
                            change(max, i, max[i], '9');
                            break;
                        }
                    }
                }
            } else {
                change(max, 0, max[0], '9');
            }

            if (min[0] == '1') {// 首位已经是最小了
                if (min.length > 1) {
                    for (int i = 1; i < min.length; ++i) {// 因为第一位是1，不能替换1了，只能找第一个不是1的值
                        if (min[i] != '1' && min[i] != '0') {
                            change(min, i, min[i], '0');
                            break;
                        }
                    }
                }
            } else {
                change(min, 0, min[0], '1');
            }

            int ans = 0;

            for (int i = 0; i < max.length; ++i) {
                ans = ans * 10 + max[i] - min[i];
            }

            return ans;
        }

        public void change(char[] num, int start, char numToChange, char changeToNum) {
            for (int i = start; i < num.length; ++i) {
                if (num[i] == numToChange) {
                    num[i] = changeToNum;
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(888, s.maxDiff(555));
        Assert.assertEquals(8, s.maxDiff(9));
        Assert.assertEquals(820000, s.maxDiff(123456));
        Assert.assertEquals(80000, s.maxDiff(10000));
        Assert.assertEquals(8700, s.maxDiff(9288));// 9988-1288
        Assert.assertEquals(882, s.maxDiff(112));// 992-110

        Assert.assertEquals(8808050, s.maxDiff(1101057));// 9909057-1101007
    }

}
