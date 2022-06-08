package redo.offer2.p16;

import javax.management.RuntimeErrorException;

/**  
 * @ClassName: P16_15  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P16_15 {

    class Solution {

        public int[] masterMind(String solution, String guess) {
            int pr = 0, fr = 0;
            for (int i = 0; i < 4; ++i) {
                if (solution.charAt(i) == guess.charAt(i)) {
                    ++pr;
                }
            }

            int[] count = new int[4], count2 = new int[4];

            for (int i = 0; i < 4; ++i) {
                ++count[index(solution.charAt(i))];
                ++count2[index(guess.charAt(i))];
            }

            for (int i = 0; i < 4; ++i) {
                fr += Math.min(count[i], count2[i]);
            }

            return new int[] {pr, fr - pr};
        }

        int index(char ch) {
            switch (ch) {
                case 'R':
                    return 0;
                case 'G':
                    return 1;
                case 'B':
                    return 2;
                case 'Y':
                    return 3;
            }
            throw new RuntimeException("");
        }
    }

}
