package redo.p0300_0399;

/**  
 * @ClassName: P374  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P374 {

    class GuessGame {
        int guess(int num) {
            return 0;
        }
    }

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1, high = n;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (guess(mid) > 0) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }


}
