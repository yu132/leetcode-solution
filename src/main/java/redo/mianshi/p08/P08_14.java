package redo.mianshi.p08;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P08_14  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P08_14 {

    class Solution {
        public int countEval(String s, int result) {
            int n = s.length();
            int[][][] num = new int[n / 2 + 1][n / 2 + 1][2];

            for (int i = 0; i < n / 2 + 1; ++i) {
                if (s.charAt(2 * i) - '0' == 0) {
                    num[i][i][0] = 1;
                } else {
                    num[i][i][1] = 1;
                }
            }
            for (int len = 2; len <= n / 2 + 1; ++len) {
                for (int i = 0; i <= n / 2 + 1 - len; ++i) {
                    for (int j = i + 1; j < i + len; ++j) {
                        char op = s.charAt(2 * j - 1);

                        int[] left = num[i][j - 1], right = num[j][i + len - 1],
                            all = num[i][i + len - 1];

                        int v00 = left[0] * right[0], v01 = left[0] * right[1],
                            v10 = left[1] * right[0], v11 = left[1] * right[1];

                        switch (op) {
                            case '^':
                                all[0] += v00 + v11;
                                all[1] += v01 + v10;
                                break;
                            case '&':
                                all[0] += v00 + v01 + v10;
                                all[1] += v11;
                                break;
                            case '|':
                                all[0] += v00;
                                all[1] += v01 + v10 + v11;
                                break;
                        }
                    }
                }
            }

            return num[0][n / 2][result];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.countEval("1^0|0|1", 0));
        Assert.assertEquals(10, s.countEval("0&0&0&1^1|0", 1));
    }
}
