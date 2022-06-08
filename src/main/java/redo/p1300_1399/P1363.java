package redo.p1300_1399;

/**  
 * @ClassName: P1363  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1363 {

    class Solution {
        public String largestMultipleOfThree(int[] digits) {
            int[] count = new int[10];
            int[] mod = new int[3];

            int sum = 0;

            for (int digit : digits) {
                ++count[digit];
                ++mod[digit % 3];
                sum += digit;
            }

            if (sum % 3 == 1) {
                if (mod[1] >= 1) {
                    for (int i = 1; i <= 9; i += 3) {
                        if (count[i] != 0) {
                            --count[i];
                            break;
                        }
                    }
                } else {
                    int c = 0;
                    outer:
                    for (int i = 2; i <= 9; i += 3) {
                        while (count[i] != 0) {
                            --count[i];
                            ++c;
                            if (c == 2) {
                                break outer;
                            }
                        }
                    }
                }
            } else if (sum % 3 == 2) {
                if (mod[2] >= 1) {
                    for (int i = 2; i <= 9; i += 3) {
                        if (count[i] != 0) {
                            --count[i];
                            break;
                        }
                    }
                } else {
                    int c = 0;
                    outer:
                    for (int i = 1; i <= 9; i += 3) {
                        while (count[i] != 0) {
                            --count[i];
                            ++c;
                            if (c == 2) {
                                break outer;
                            }
                        }
                    }
                }
            }

            StringBuilder buf = new StringBuilder();

            for (int i = 9; i > 0; --i) {
                for (int j = 0; j < count[i]; ++j) {
                    buf.append(i);
                }
            }

            if (count[0] != 0) {
                if (buf.length() != 0) {
                    for (int j = 0; j < count[0]; ++j) {
                        buf.append(0);
                    }
                } else {
                    return "0";
                }
            }

            return buf.toString();
        }
    }

}
