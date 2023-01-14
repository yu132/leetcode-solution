package old._1500_1599;

/**  
 * @ClassName: _1534  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年8月25日  
 *  
 */
public class _1534 {

    class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {

            int count = 0;

            for (int i = 0; i < arr.length; ++i) {
                for (int j = i + 1; j < arr.length; ++j) {

                    if (Math.abs(arr[i] - arr[j]) > a) {
                        continue;
                    }

                    for (int k = j + 1; k < arr.length; ++k) {

                        if (Math.abs(arr[j] - arr[k]) > b) {
                            continue;
                        }

                        if (Math.abs(arr[i] - arr[k]) > c) {
                            continue;
                        }

                        ++count;
                    }
                }
            }

            return count;

        }
    }

}
