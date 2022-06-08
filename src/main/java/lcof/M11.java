package lcof;

/**  
 * @ClassName: M11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月12日  
 *  
 */
public class M11 {

    class Solution {
        public int minArray(int[] numbers) {
            int low = 0, high = numbers.length - 1;
            while (true) {
                if (low >= high) {
                    return numbers[low];
                }
                int mid = (low + high) >>> 1;
                if (numbers[mid] > numbers[high]) {
                    low = mid + 1;
                } else if (numbers[mid] == numbers[high]) {
                    --high;
                } else {
                    high = mid;
                }
            }
        }
    }

}
