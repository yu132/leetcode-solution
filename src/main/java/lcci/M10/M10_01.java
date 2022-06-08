package lcci.M10;

/**  
 * @ClassName: M10_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月7日  
 *  
 */
public class M10_01 {

    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            System.arraycopy(A, 0, A, n, A.length - n);

            int iA = n, iB = 0, index = 0;

            while (iA != A.length && iB != B.length) {
                if (A[iA] <= B[iB]) {
                    A[index++] = A[iA++];
                } else {
                    A[index++] = B[iB++];
                }
            }
            while (iA != A.length) {
                A[index++] = A[iA++];
            }
            while (iB != B.length) {
                A[index++] = B[iB++];
            }
        }
    }

}
