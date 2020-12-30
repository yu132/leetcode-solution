package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P507  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P507 {

    class Solution {
        public boolean checkPerfectNumber(int num) {
            int sum = 0;
            for (int i = (int)Math.sqrt(num - 1); i >= 2; --i) {// 先不算n*n==num和1*num==num两种情况
                if (num % i == 0) {
                    sum += i;
                    sum += num / i;
                }
            }

            sum += 1;// 1*num==num一定成立，但是只计1，不计num

            if ((int)Math.sqrt(num) * (int)Math.sqrt(num) == num) {// n*n==num，但是只计一个n
                sum += (int)Math.sqrt(num);
            }
            return sum == num;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.checkPerfectNumber(28));
        assertEquals(true, s.checkPerfectNumber(6));
        assertEquals(true, s.checkPerfectNumber(496));
        assertEquals(true, s.checkPerfectNumber(8128));
        assertEquals(false, s.checkPerfectNumber(2));
        assertEquals(false, s.checkPerfectNumber(64));
    }

}
