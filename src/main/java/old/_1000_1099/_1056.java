package old._1000_1099;

import java.util.ArrayList;

/**  
 * @ClassName: _1056  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月30日  
 *  
 */
public class _1056 {

    class Solution {
        public boolean confusingNumber(int N) {
            int[]              arr = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};

            ArrayList<Integer> bl  = new ArrayList<>();
            ArrayList<Integer> al  = new ArrayList<>();

            while (N != 0) {
                int before = N % 10;
                N /= 10;
                int after = arr[before];
                if (after == -1) {
                    return false;
                }
                bl.add(before);
                al.add(after);
            }

            for (int i = 0; i < bl.size(); ++i) {
                if (bl.get(i) != al.get(al.size() - i - 1)) {
                    return true;
                }
            }

            return false;
        }
    }

}
