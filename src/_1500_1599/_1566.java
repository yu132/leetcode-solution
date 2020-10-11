package _1500_1599;

/**  
 * @ClassName: _1566  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月2日  
 *  
 */
public class _1566 {

    class Solution {
        public boolean containsPattern(int[] arr, int m, int k) {
            l:
            for (int i = 0; i <= arr.length - m * k; ++i) {
                for (int j = 1; j < k; ++j) {
                    for (int x = 0; x < m; ++x) {
                        if (arr[i + x] != arr[i + j * m + x]) {
                            continue l;
                        }
                    }
                }
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1566().new Solution().containsPattern(new int[] {2, 2, 2, 2}, 2, 2));
    }
}
