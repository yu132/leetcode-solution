package _0000_0099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _65  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class _65 {

    class Solution {

        /*
         * 0 -> +
         * 1 -> -
         * 2 -> num
         * 3 -> point
         * 4 -> e 
         */

        public boolean isNumber(String s) {
            List<Integer> list = new ArrayList<>();

            s = s.trim();// 允许前导和后缀空格

            boolean numNow = false;

            for (int i = 0; i < s.length(); ++i) {
                char each = s.charAt(i);

                if (each >= '0' && each <= '9') {
                    if (!numNow) {
                        numNow = true;
                    }
                } else {
                    if (numNow) {
                        numNow = false;
                        list.add(2);
                    }

                    switch (each) {
                        case '+':
                            list.add(0);
                            break;
                        case '-':
                            list.add(1);
                            break;
                        case '.':
                            list.add(3);
                            break;
                        case 'e':
                            list.add(4);
                            break;
                        default:// 非法字符
                            return false;
                    }
                }
            }

            if (numNow) {
                list.add(2);
            }

            return num(list);
        }

        // num => [-|+] [num [. [num]]|. num] [e [-|+]num]
        public boolean num(List<Integer> list) {
            int now = 0;

            if (now >= list.size()) {// 没有数字
                return false;
            }
            int sign = list.get(now);

            if (sign == 0 | sign == 1) {// [-|+]
                ++now;
                if (now >= list.size()) {// 没有数字
                    return false;
                }
                sign = list.get(now);
            }

            if (sign != 2) {// 此处不是数字

                if (sign != 3) {// 也不是点号
                    return false;
                } else {// .

                    ++now;
                    if (now >= list.size()) {// [-|+] . 前后都没有数字 不合法
                        return false;
                    }
                    sign = list.get(now);

                    if (sign != 2) {// 此处不是数字
                        return false;
                    } else {
                        ++now;
                        if (now >= list.size()) {// [-|+] .num 合法
                            return true;
                        }
                        sign = list.get(now);
                    }
                }

            } else {// 是数字
                ++now;
                if (now >= list.size()) {// [-|+] num 合法
                    return true;
                }
                sign = list.get(now);

                if (sign == 3) {// .
                    ++now;
                    if (now >= list.size()) {// [-|+] num. 合法
                        return true;
                    }
                    sign = list.get(now);

                    if (sign == 2) {// 此是数字
                        ++now;
                        if (now >= list.size()) {// [-|+] num.num 合法
                            return true;
                        }
                        sign = list.get(now);
                    }
                }
            }

            if (sign == 4) {// e

                ++now;
                if (now >= list.size()) {// e后面啥都没了 非法
                    return false;
                }
                sign = list.get(now);

                if (sign == 0 | sign == 1) {// [-|+]
                    ++now;
                    if (now >= list.size()) {// 没有数字
                        return false;
                    }
                    sign = list.get(now);
                }

                if (sign != 2) {// 此处不是数字
                    return false;
                } else {// 是数字
                    ++now;
                    if (now >= list.size()) {// [-|+] num [. [num]] e [-|+]num 合法
                        return true;
                    }
                    sign = list.get(now);
                }
            }

            // 有多余字符
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _65().new Solution().isNumber("+1e"));
    }

}
