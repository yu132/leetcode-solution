package redo.offer2.p10;

/**  
 * @ClassName: P10_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P10_01 {

    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int index = A.length - 1, index1 = m - 1, index2 = n - 1;
            while (index1 >= 0 && index2 >= 0) {
                if (A[index1] > B[index2]) {
                    A[index--] = A[index1--];
                } else {
                    A[index--] = B[index2--];
                }
            }
            while (index2 >= 0) {
                A[index--] = B[index2--];
            }
        }
    }

}
