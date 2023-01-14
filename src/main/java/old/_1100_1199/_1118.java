package old._1100_1199;

/**  
 * @ClassName: _1118  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1118 {

    class Solution {

        public final int[] arr = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public boolean isLeap(int year) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }

        public int numberOfDays(int Y, int M) {
            return M != 2 ? arr[M] : isLeap(Y) ? 29 : 28;
        }
    }

}
