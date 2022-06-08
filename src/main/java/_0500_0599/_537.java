package _0500_0599;

/**  
 * @ClassName: _537  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月20日  
 *  
 */
public class _537 {

    class Solution {
        public String complexNumberMultiply(String a, String b) {
            int[] A = parse(a);
            int[] B = parse(b);

            return (A[0] * B[0] - A[1] * B[1]) + "+" + (A[0] * B[1] + A[1] * B[0]) + "i";
        }

        private int[] parse(String str) {
            int index4add = str.indexOf('+');
            return new int[] {Integer.valueOf(str.substring(0, index4add)),
                Integer.valueOf(str.substring(index4add + 1, str.length() - 1))};
        }
    }

}
