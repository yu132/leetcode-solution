package redo.Util.ag.subArray.maxLenSubArr;

/**  
 * @ClassName: MaxLenSubArrUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class MaxLenSubArrUtil {
    // test by leetcode-1208
    static int maxLenSubArr(int[] arr, WindowMaintainer maintainer) {
        int max = 0, left = 0;
        for (int right = 0; right < arr.length; ++left) {
            while (maintainer.windowMeetRequirements()) {
                max = Math.max(max, right - left);
                if (right >= arr.length) {
                    break;
                }
                maintainer.insertRight(arr[right++]);
            }
            maintainer.removeLeft(arr[left]);
        }
        return max;
    }

    static interface WindowMaintainer {
        void insertRight(int rightValue);

        void removeLeft(int leftValue);

        boolean windowMeetRequirements();
    }

    static class LittleThanNWindowMaintainer implements WindowMaintainer {

        int n;
        int sum = 0;

        public LittleThanNWindowMaintainer(int n) {
            super();
            this.n = n;
        }

        @Override
        public void insertRight(int rightValue) {
            sum += rightValue;
        }

        @Override
        public void removeLeft(int leftValue) {
            sum -= leftValue;
        }

        @Override
        public boolean windowMeetRequirements() {
            return sum <= n;
        }

    }

}
