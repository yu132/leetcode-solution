package lcof;

/**  
 * @ClassName: M66  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月24日  
 *  
 */
public class M66 {

    class Solution {
        public int[] constructArr(int[] a) {
            if (a.length == 0) {
                return new int[0];
            }
            if (a.length == 1) {
                return new int[1];
            }

            int[] productF = new int[a.length];
            int[] productB = new int[a.length];

            int   f        = 1, b = 1;
            for (int i = 0; i < a.length; ++i) {
                productF[i]                = (f *= a[i]);
                productB[a.length - i - 1] = (b *= a[a.length - i - 1]);
            }

            int[] ans = new int[a.length];

            ans[0]            = productB[1];
            ans[a.length - 1] = productF[a.length - 2];

            for (int i = 1; i < a.length - 1; ++i) {
                ans[i] = productF[i - 1] * productB[i + 1];
            }

            return ans;
        }
    }

}
