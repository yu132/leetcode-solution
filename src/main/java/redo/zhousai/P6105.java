package redo.zhousai;

public class P6105 {

    class Solution {
        public int maximumXOR(int[] nums) {
            int val = 0;
            for (int num : nums) {
                val |= num;
            }
            return val;
        }
    }

}
