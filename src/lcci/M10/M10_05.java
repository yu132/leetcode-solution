package lcci.M10;

/**  
 * @ClassName: M10_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月8日  
 *  
 */
public class M10_05 {

    class Solution {
        public int findString(String[] words, String s) {

            int low = 0, high = words.length;

            while (low < high) {
                int mid   = (low + high) >>> 1;

                int right = mid, left = mid;

                while (right != words.length && words[right].equals("")) {
                    ++right;
                }

                while (left >= 0 && words[left].equals("")) {
                    --left;
                }

                if (right == words.length) {
                    if (left == -1) {
                        return -1;
                    } else {
                        int comp = words[left].compareTo(s);
                        if (comp > 0) {
                            high = left;
                        } else if (comp == 0) {
                            return left;
                        } else {
                            return -1;
                        }
                    }
                } else {
                    if (left == -1) {
                        int comp = words[right].compareTo(s);
                        if (comp < 0) {
                            low = right + 1;
                        } else if (comp == 0) {
                            return right;
                        } else {
                            return -1;
                        }
                    } else {
                        int compl = words[left].compareTo(s);
                        if (compl > 0) {
                            high = left;
                        } else if (compl == 0) {
                            return left;
                        } else {
                            int compr = words[right].compareTo(s);
                            if (compr < 0) {
                                low = right + 1;
                            } else if (compr == 0) {
                                return right;
                            } else {
                                return -1;
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new M10_05().new Solution().findString(
            new String[] {"DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"},
            "mCrS"));
    }

}
