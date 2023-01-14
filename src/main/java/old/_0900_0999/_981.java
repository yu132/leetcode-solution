package old._0900_0999;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**  
 * @ClassName: _981  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月9日  
 *  
 */
public class _981 {

    class TimeMap {

        HashMap<String, Node> map = new HashMap<>();

        /** Initialize your data structure here. */
        public TimeMap() {}

        public void set(String key, String value, int timestamp) {
            Node node = map.computeIfAbsent(key, (x) -> new Node());
            while (!node.timestamp.isEmpty() && node.timestamp.get(node.timestamp.size() - 1) == timestamp) {
                node.timestamp.remove(node.timestamp.size() - 1);
                node.values.remove(node.values.size() - 1);
            }
            node.timestamp.add(timestamp);
            node.values.add(value);
        }

        public String get(String key, int timestamp) {
            Node node = map.get(key);
            if (node == null) {
                return "";
            }
            int ub = upperBound(node.timestamp, timestamp);
            if (ub == 0) {
                return "";
            } else {
                return node.values.get(ub - 1);
            }
        }

        class Node {
            ArrayList<Integer> timestamp = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
        }

        private int upperBound(List<Integer> list, int key) {
            int first = 0, len = list.size();
            int half, middle;

            while (len > 0) {
                half   = len >> 1;
                middle = first + half;
                if (list.get(middle) > key) // 中位数大于key,在包含last的左半边序列中查找。
                    len = half;
                else {
                    first = middle + 1;    // 中位数小于等于key,在右半边序列中查找。
                    len   = len - half - 1;
                }
            }
            return first;
        }
    }

}
