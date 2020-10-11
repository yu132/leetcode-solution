package _0700_0799;

/**  
 * @ClassName: _702  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月17日  
 *  
 */
public class _702 {

    interface ArrayReader {
        public int get(int index);
    }

    class Solution {
        public int search(ArrayReader reader, int target) {
            int ans = lowerBound(reader, 0, Integer.MAX_VALUE, target);
            return reader.get(ans) == target ? ans : -1;
        }

        public int lowerBound(ArrayReader reader, int from, int size, int key) {
            int first = from, middle;
            int half, len;
            len = size;

            while (len > 0) {
                half   = len >> 1;
                middle = first + half;

                if (reader.get(middle) < key) {
                    first = middle + 1;
                    len   = len - half - 1; // 在右边子序列中查找
                } else
                    len = half; // 在左边子序列（包含middle）中查找
            }
            return first;
        }
    }

}
