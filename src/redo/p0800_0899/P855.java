package redo.p0800_0899;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**  
 * @ClassName: P855  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月28日  
 *  
 */
public class P855 {

    class ExamRoom {

        Map<Integer, int[]> left, right;
        TreeSet<int[]> maxLenRange;
        int N;

        public ExamRoom(int N) {
            this.N = N;
            left = new HashMap<>();
            right = new HashMap<>();
            maxLenRange = new TreeSet<>((a, b) -> {
                int lenA = compLen(a), lenB = compLen(b);
                if (lenA == lenB) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(lenB, lenA);
            });
            addRange(new int[] {-1, N});
        }

        int compLen(int[] a) {
            if (a[0] == -1 || a[1] == N) {
                return a[1] - a[0] - 1;
            }
            return (a[1] - a[0]) >>> 1;
        }

        void addRange(int[] range) {
            left.put(range[0], range);
            right.put(range[1], range);
            maxLenRange.add(range);
        }

        void removeRange(int[] range) {
            left.remove(range[0]);
            right.remove(range[1]);
            maxLenRange.remove(range);
        }

        int spilt(int[] range) {
            int midPoint;
            if (range[0] == -1) {
                midPoint = 0;
            } else if (range[1] == N) {
                midPoint = N - 1;
            } else {
                midPoint = (range[0] + range[1]) >>> 1;
            }

            int[] left = new int[] {range[0], midPoint};
            int[] right = new int[] {midPoint, range[1]};

            removeRange(range);
            addRange(left);
            addRange(right);

            return midPoint;
        }

        void merge(int midPoint) {
            int[] left = this.left.get(midPoint), right = this.right.get(midPoint);
            int[] merge = new int[] {right[0], left[1]};

            removeRange(left);
            removeRange(right);
            addRange(merge);
        }

        public int seat() {
            int[] maxRange = maxLenRange.first();
            return spilt(maxRange);
        }

        public void leave(int p) {
            merge(p);
        }
    }

}
