package redo.offer;

/**  
 * @ClassName: P66  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P66 {

    class Solution {
        public int[] constructArr(int[] a) {
            int[] left = new int[a.length], right = new int[a.length];
            int product = 1;
            for (int i = 0; i < a.length; ++i) {
                left[i] = product;
                product *= a[i];
            }
            product = 1;
            for (int i = a.length - 1; i >= 0; --i) {
                right[i] = product;
                product *= a[i];
            }
            for (int i = 0; i < a.length; ++i) {
                left[i] = left[i] * right[i];
            }
            return left;
        }
    }

}
