package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P13  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月16日  
 *  
 */
public class P13 {

    class Solution {

        // 下推自动机

        // I -> I, II, III, IV, IX
        // V -> V
        // X -> X, XX, XXX, XL, XC
        // L -> L
        // C -> C, CC, CCC, CD, CM
        // D -> D
        // M -> M, MM, MMM

        int index = 0;

        int sum = 0;

        String s;

        public int romanToInt(String s) {

            this.s = s;

            while (index < s.length()) {
                char c = s.charAt(index);
                ++index;
                switch (c) {
                    case 'I':
                        I();
                        break;
                    case 'V':
                        sum += 5;
                        break;
                    case 'X':
                        X();
                        break;
                    case 'L':
                        sum += 50;
                        break;
                    case 'C':
                        C();
                        break;
                    case 'D':
                        sum += 500;
                        break;
                    case 'M':
                        sum += 1000;
                        break;
                }
            }

            return sum;
        }

        public void I() {
            base(1, 'I', 'V', 'X');
        }

        public void X() {
            base(10, 'X', 'L', 'C');
        }

        public void C() {
            base(100, 'C', 'D', 'M');
        }

        public void base(int exp, char i, char v, char x) {
            if (index == s.length()) {
                sum += 1 * exp;
                return;
            }

            char c = s.charAt(index);
            ++index;
            if (c == i) {
                if (index == s.length()) {
                    sum += 2 * exp;
                    return;
                }
                if (s.charAt(index) == i) {
                    ++index;
                    sum += 3 * exp;
                } else {
                    sum += 2 * exp;
                }
            } else if (c == v) {
                sum += 4 * exp;
            } else if (c == x) {
                sum += 9 * exp;
            } else {
                sum += 1 * exp;
                --index;
            }
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.romanToInt("III"));
        s = new Solution();
        assertEquals(4, s.romanToInt("IV"));
        s = new Solution();
        assertEquals(9, s.romanToInt("IX"));
        s = new Solution();
        assertEquals(58, s.romanToInt("LVIII"));
        s = new Solution();
        assertEquals(1994, s.romanToInt("MCMXCIV"));
        s = new Solution();
        assertEquals(621, s.romanToInt("DCXXI"));
        s = new Solution();
        assertEquals(1570, s.romanToInt("MDLXX"));
    }

}
