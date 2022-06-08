package lcof;

/**  
 * @ClassName: M7  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M17 {

    class Solution {
        public int[] printNumbers(int n) {
            int   max = (int)(Math.pow(10, n) - 1);
            int[] arr = new int[max];
            for (int i = 1; i <= max; ++i) {
                arr[i - 1] = i;
            }
            return arr;
        }
    }

}
