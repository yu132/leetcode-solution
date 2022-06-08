package _0600_0699;

/**  
 * @ClassName: _640  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月21日  
 *  
 */
public class _640 {

    class Solution {
        public String solveEquation(String equation) {

            this.equation = equation;
            index         = 0;

            int[] ans = parse();

            if (ans[0] == 0) {
                if (ans[1] == 0) {
                    return "Infinite solutions";
                } else {
                    return "No solution";
                }
            }

            return "x=" + (-ans[1] / ans[0]);
        }

        String equation;
        int index;

        public int[] parse() {
            int[] ex1 = experssion();
            ++index;
            int[] ex2 = experssion();
            ex1[0] -= ex2[0];
            ex1[1] -= ex2[1];
            return ex1;
        }

        public int[] experssion() {
            int[] nums = new int[2];

            do {
                int[] ans = numOrVar();
                nums[0] += ans[0];
                nums[1] += ans[1];
            } while (index != equation.length() && (equation.charAt(index) == '-' || equation.charAt(index) == '+'));

            return nums;
        }

        public int[] numOrVar() {

            int sign = 1;

            if (equation.charAt(index) == '-') {
                sign = -1;
                ++index;
            } else if (equation.charAt(index) == '+') {
                sign = 1;
                ++index;
            }

            boolean hasNum = false;;

            int num = 0;
            while (index != equation.length() && equation.charAt(index) >= '0' && equation.charAt(index) <= '9') {
                hasNum = true;
                num    = num * 10 + equation.charAt(index++) - '0';
            }

            if (index != equation.length() && equation.charAt(index) == 'x') {
                ++index;
                if (!hasNum) {
                    return new int[] {1 * sign, 0};
                }
                return new int[] {num * sign, 0};
            }

            return new int[] {0, num * sign};
        }
    }

    public static void main(String[] args) {
        System.out.println(new _640().new Solution().solveEquation("x=x+2"));
    }

}
