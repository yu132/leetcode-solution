package old._0800_0899;

import java.util.Arrays;

/**  
 * @ClassName: _881  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月3日  
 *  
 */
public class _881 {

    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int low = 0, high = people.length - 1, count = 0;
            while (low < high) {
                if (people[low] + people[high] <= limit) {
                    ++count;
                    ++low;
                    --high;
                } else {
                    ++count;
                    --high;
                }
            }
            return count + (low == high ? 1 : 0);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _881().new Solution().numRescueBoats(new int[] {3, 5, 3, 4}, 5));
    }
}
