package redo.Util.ds.differentialArray;

import redo.p1900_1999.P1943;

/**
 * @author 余定邦
 * @ClassName: DifferentialArray
 * @Description: 差分数组是用于范围更新的一种数组
 * 其通过将数值转化为相邻元素的差值，从而将绝对值转化为相对值
 * 将范围的第一个差值和最后一个差值进行改变，能保证范围内的值发生变化
 * 但是范围外的值依然保持不变
 * @date 2020年12月31日
 * @see P1943 特殊的差分数组用法，可用于区分不同类型的累加
 */
public class DifferentialArrayUtil {

    static class DifferentialArray {

        int[] differentialArray;

        public DifferentialArray(int[] nums) {
            differentialArray = new int[nums.length + 1];
            for (int i = 1; i < nums.length; ++i) {
                differentialArray[i] = nums[i] - nums[i - 1];
            }
        }

        public DifferentialArray(int len) {
            differentialArray = new int[len + 1];
        }

        // to是不包括的
        public void addRange(int value, int start, int to) {
            differentialArray[start] += value;
            differentialArray[to] -= value;
        }

        public int[] getNums() {
            int[] nums = new int[differentialArray.length - 1];
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += differentialArray[i];
                nums[i] = sum;
            }
            return nums;
        }

    }


}
