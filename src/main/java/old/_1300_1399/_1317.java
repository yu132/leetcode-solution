/**
 * @Title: _1317.java
 *
 * @Package old._1300_1399
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 *
 */
package old._1300_1399;

/**
 * @ClassName: _1317
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 * 
 */
public class _1317 {

    class Solution {
        public int[] getNoZeroIntegers(int n) {
            for (int i = 1;; ++i) {
                int temp = i;
                if (continues0(temp)) {
                    continue;
                }
                temp = n - i;
                if (continues0(temp)) {
                    continue;
                }
                return new int[] {i, n - i};
            }
        }

        public boolean continues0(int num) {
            while (num != 0) {
                if (num % 10 == 0) {
                    return true;
                }
                num /= 10;
            }
            return false;
        }
    }

    public static boolean continues0(int num) {
        while (num != 0) {
            if (num % 10 == 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(continues0(1));
    }

}
