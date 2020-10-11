package lcci.M08;

/**  
 * @ClassName: M08_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月4日  
 *  
 */
public class M08_05 {

    class Solution {
        public int multiply(int A, int B) {

            int     base = A > B ? A : B;
            int     mul  = A <= B ? A : B;

            boolean sign = mul >= 0;

            mul = Math.abs(mul);

            int num = 0;

            while (mul > 0) {
                if (mul % 2 == 1) {
                    num += base;
                }
                base   = base + base;
                mul  >>= 1;
            }

            return sign ? num : -num;
        }
    }

}
