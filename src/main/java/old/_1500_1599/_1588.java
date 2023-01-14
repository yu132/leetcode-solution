package old._1500_1599;

/**  
 * @ClassName: _1588  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年10月11日  
 *  
 */
public class _1588 {

    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {

            int sum        = 0;

            // 取最大奇数
            int maxProduct = (arr.length & 1) == 1 ? arr.length : arr.length - 1;

            // 奇数和 1+3+7+...+(2n-1) = n^2
            int n          = (1 + maxProduct) / 2;
            int product    = n * n;

            for (int i = 0; i < arr.length; ++i) {
                sum += arr[i] * product;
            }

            for (int i = 1; i <= maxProduct; i += 2) {// O(n^2) 有更好的解法
                for (int j = 0; j < i; ++j) {
                    sum -= arr[j] * (i - j - 1);
                    sum -= arr[arr.length - j - 1] * (i - j - 1);
                }
            }

            return sum;
        }
    }

}
