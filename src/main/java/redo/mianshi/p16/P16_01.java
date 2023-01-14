package redo.mianshi.p16;

/**  
 * @ClassName: P16_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P16_01 {

    class Solution {
        public int[] swapNumbers(int[] numbers) {
            numbers[0] ^= numbers[1];
            numbers[1] ^= numbers[0];
            numbers[0] ^= numbers[1];
            return numbers;
        }
    }

}
