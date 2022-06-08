package redo.p1700_1799;

/**  
 * @ClassName: P1716  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1716 {

    class Solution {
        public int totalMoney(int n) {

            int k = n / 7;

            int c = k * 7, cc = 1 + k;

            int count = k * (1 + 2 + 3 + 4 + 5 + 6 + 7) + k * (k - 1) / 2 * 7;

            while (c < n) {
                count += cc;
                ++cc;
                ++c;
            }

            return count;
        }
    }

}
