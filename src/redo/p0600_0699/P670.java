package redo.p0600_0699;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P670  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P670 {

    class Solution {
        public int maximumSwap(int num) {

            int a = num;

            if (num == 0) {
                return 0;
            }

            List<Integer> numList = new ArrayList<>();

            while (num != 0) {
                numList.add(num % 10);
                num /= 10;
            }

            int i = numList.size() - 2;
            for (; i >= 0; --i) {
                if (numList.get(i) > numList.get(i + 1)) {
                    break;
                }
            }

            if (i == -1) {
                return a;
            }

            int mIndex = i;

            for (int j = i - 1; j >= 0; --j) {
                if (numList.get(j) >= numList.get(mIndex)) {
                    mIndex = j;
                }
            }

            for (int k = numList.size() - 1; k > i; --k) {
                if (numList.get(mIndex) > numList.get(k)) {
                    int temp = numList.get(k);
                    numList.set(k, numList.get(mIndex));
                    numList.set(mIndex, temp);
                    break;
                }
            }

            int ans = 0;

            for (int x = numList.size() - 1; x >= 0; --x) {
                ans = ans * 10 + numList.get(x);
            }

            return ans;
        }
    }

}
