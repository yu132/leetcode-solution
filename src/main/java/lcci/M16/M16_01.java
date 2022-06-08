package lcci.M16;

/**  
 * @ClassName: M16_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月12日  
 *  
 */
public class M16_01 {

    class Solution {
        public int[] swapNumbers(int[] numbers) {
            numbers[0] = numbers[0] ^ numbers[1];
            numbers[1] = numbers[0] ^ numbers[1];
            numbers[0] = numbers[0] ^ numbers[1];
            return numbers;
        }
    }

}
