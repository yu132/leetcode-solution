package old._1000_1099;

/**  
 * @ClassName: _1053  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月23日  
 *  
 */
public class _1053 {

    class Solution {
        public int[] prevPermOpt1(int[] A) {
            for (int i = A.length - 1; i >= 1; --i) {
                if (A[i - 1] > A[i]) {
                    int max = A[i], index = i;
                    for (int j = i + 1; j < A.length; ++j) {
                        if (A[j] >= max && A[j] < A[i - 1]) {
                            max   = A[j];
                            index = j;
                        }
                    }
                    int temp = A[i - 1];
                    A[i - 1] = A[index];
                    A[index] = temp;
                    return A;
                }
            }
            return A;
        }
    }

}
