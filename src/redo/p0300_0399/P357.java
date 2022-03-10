package redo.p0300_0399;

/**  
 * @ClassName: P357  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P357 {

    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }

            int dp = 0, sum = 0;
            for (int i = 1; i < n; ++i) {
                sum +=
                    (dp = (dp * 10 + (9 * (int)Math.pow(10, i - 1) - dp) * i));

                // dp : i位时有重复的数字个数
                // dp*10 : 前i位已经有重复的，因此加上0-9都可以，共10种

                // 9 * (int)Math.pow(10, i - 1) - dp ：是前i位中不重复的数字个数
                // 例如 9是因为不能以0开头 —> 100-999 -> i=3 共900个
                // * i 是因为前i位不相同，那么必须出现一个前i位中出现的数字才重复
            }

            return (int)Math.pow(10, n) - sum;
        }
    }

}
