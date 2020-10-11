package _1500_1599;

/**  
 * @ClassName: _1539  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年8月25日  
 *  
 */
public class _1539 {

    class Solution {
        public int findKthPositive(int[] arr, int k) {

            int x = 0, num = 1;

            for (int i = 0; i < arr.length; ++i) {
                if (num == arr[i]) {
                    ++num;
                    continue;
                } else {
                    ++x;
                    if (x == k) {
                        return num;
                    }
                    ++num;
                    --i;
                }
            }

            return num + k - x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1539().new Solution().findKthPositive(new int[] {2, 3, 4, 7, 11}, 10));
    }

}
