package _0100_0199;

public class _137 {

    class Solution {

        /**
         * st0  a 0 b 0
         *  	     
         * st0 + 0  (b = 0 ^ 0 & ~0 = 0, a = 0 ^ 0 & ~0 = 0) -> a 0, b 0 -> st0
         * 
         * st0 + 1  (b = 0 ^ 1 & ~0 = 1, a = 0 ^ 1 & ~1 = 0) -> a 0, b 1 -> st1
         * 
         * st1 + 0  (b = 1 ^ 0 & ~0 = 1, a = 0 ^ 0 & ~1 = 0) -> a 0, b 1 -> st1
         * 
         * st1 + 1  (b = 1 ^ 1 & ~0 = 0, a = 0 ^ 1 & ~0 = 1) -> a 1, b 0 -> st2
         * 
         * st2 + 0  (b = 0 ^ 0 & ~1 = 0, a = 1 ^ 0 & ~0 = 1) -> a 1, b 0 -> st2
         * 
         * st2 + 1  (b = 0 ^ 1 & ~1 = 0, a = 1 ^ 1 & ~0 = 1) -> a 0, b 0 -> st0
         * 
         * @Title: singleNumber  
         *
         * @Description: TODO(这里用一句话描述这个方法的作用)  
         *
         * @param nums
         * @return
         *
         * @return int 
         *
         * @throws
         */
        public int singleNumber(int[] nums) {
            int a = 0, b = 0;
            for (int c : nums) {
                b = b ^ c & ~a;
                a = a ^ c & ~b;
            }
            return b;
        }
    }


    public static void main(String[] args) {
        System.out.println(1 ^ 1 & ~0);
    }

}
