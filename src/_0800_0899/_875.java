package _0800_0899;

/**  
 * @ClassName: _875  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月3日  
 *  
 */
public class _875 {

    class Solution {
        public int minEatingSpeed(int[] piles, int H) {

            int low = 1, high = (int)10e9;

            l:
            while (low < high) {
                int mid  = (low + high) >>> 1;
                int time = H;
                for (int i = 0; i < piles.length; ++i) {
                    time -= Math.ceil((double)piles[i] / mid);
                    if (time < 0) {
                        low = mid + 1;
                        continue l;
                    }
                }
                high = mid;
            }
            return low;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _875().new Solution().minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6));
    }
}
