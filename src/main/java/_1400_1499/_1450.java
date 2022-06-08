package _1400_1499;

/**  
 * @ClassName: _1450  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月20日  
 *  
 */
public class _1450 {

    class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int count = 0;
            for (int i = 0; i < startTime.length; ++i) {
                if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                    ++count;
                }
            }
            return count;
        }
    }

}
