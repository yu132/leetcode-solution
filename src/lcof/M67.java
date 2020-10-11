package lcof;

/**  
 * @ClassName: M67  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月25日  
 *  
 */
public class M67 {

    class Solution {
        public int strToInt(String str) {

            int     sign     = 1;
            long    num      = 0;

            boolean isNumNow = false;

            for (char c : str.toCharArray()) {
                if (!isNumNow) {
                    if (c == ' ') {
                        continue;
                    } else if (c >= '0' && c <= '9') {
                        isNumNow = true;
                        num      = num * 10 + c - '0';
                    } else if (c == '-') {
                        sign     = -1;
                        isNumNow = true;
                    } else if (c == '+') {
                        isNumNow = true;
                    } else {
                        return 0;
                    }
                } else {// num only
                    if (c >= '0' && c <= '9') {
                        num = num * 10 + c - '0';
                    } else {
                        break;
                    }
                }

                if (num > Integer.MAX_VALUE) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }

            return (int)(sign * num);
        }
    }


}
