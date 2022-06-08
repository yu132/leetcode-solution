package redo.p0200_0299;

/**  
 * @ClassName: P278  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P278 {
    class VersionControl {
        boolean isBadVersion(int version) {
            return false;
        }
    }

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int low = 1, high = n;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (!isBadVersion(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }


}
