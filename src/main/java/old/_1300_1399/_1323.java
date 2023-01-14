/**
 * @Title: _1323.java
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
 * @ClassName: _1323
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 * 
 */
public class _1323 {

    class Solution {
        public int maximum69Number(int num) {
            int temp  = num;
            int index = 0;
            int count = 1;
            while (temp != 0) {
                if (temp % 10 == 6) {
                    index = count;
                }
                ++count;
                temp /= 10;
            }
            if (index == 0) {
                return num;
            }
            return (int)(num + 3 * Math.pow(10, index - 1));
        }
    }

}
