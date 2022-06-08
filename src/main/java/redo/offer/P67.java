package redo.offer;

/**  
 * @ClassName: P67  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P67 {

    class Solution {
        public int strToInt(String str) {
            boolean isNum = false, hasOneNum = false, overflow = false;
            int num = 0, sign = 1;
            int MAX_DIV_10 = Integer.MAX_VALUE / 10;
            for (char ch : str.toCharArray()) {
                if (!isNum) {
                    if (ch == ' ') {
                        continue;
                    }
                    isNum = true;
                    if (ch == '+') {
                        continue;
                    } else if (ch == '-') {
                        sign = -1;
                        continue;
                    } else if (Character.isDigit(ch)) {
                        num = num * 10 + (ch - '0');
                        hasOneNum = true;
                    } else {
                        break;
                    }
                } else {
                    if (Character.isDigit(ch)) {
                        hasOneNum = true;
                        if ((num < MAX_DIV_10)) {
                            num = num * 10 + (ch - '0');
                        } else if (num == MAX_DIV_10) {
                            if (sign == 1 && ch - '0' <= 7) {
                                num = num * 10 + (ch - '0');
                                continue;
                            } else if (sign == -1 && ch - '0' <= 8) {
                                num = num * 10 + (ch - '0');
                                continue;
                            }
                            overflow = true;
                            break;
                        } else {
                            overflow = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (!isNum || !hasOneNum) {
                return 0;
            }

            if (overflow) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            return sign * num;
        }
    }

}
