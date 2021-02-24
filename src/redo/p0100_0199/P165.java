package redo.p0100_0199;

/**  
 * @ClassName: P165  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P165 {

    class Solution {
        public int compareVersion(String version1, String version2) {
            int index1 = 0, index2 = 0;
            while (index1 < version1.length() || index2 < version2.length()) {
                int v1 = 0;
                while (index1 < version1.length()) {
                    if (version1.charAt(index1) == '.') {
                        ++index1;
                        break;
                    }
                    v1 = v1 * 10 + version1.charAt(index1++) - '0';
                }

                int v2 = 0;
                while (index2 < version2.length()) {
                    if (version2.charAt(index2) == '.') {
                        ++index2;
                        break;
                    }
                    v2 = v2 * 10 + version2.charAt(index2++) - '0';
                }

                if (v1 < v2) {
                    return -1;
                } else if (v1 > v2) {
                    return 1;
                }
            }
            return 0;
        }

    }

}
