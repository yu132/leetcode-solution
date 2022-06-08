package redo.p0300_0399;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P388  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P388 {

    class Solution {
        public int lengthLongestPath(String input) {
            Deque<Integer> stack = new LinkedList<>();

            int index = 0;

            int maxTabCount = -1, tableCount = 0, len = 0;

            int max = 0;

            while (index < input.length()) {
                tableCount = 0;
                while (index < input.length() && input.charAt(index) == '\t') {
                    ++index;// '\t'
                    ++tableCount;
                }
                if (tableCount <= maxTabCount) {
                    int diff = maxTabCount - tableCount + 1;
                    for (int i = 0; i < diff; ++i) {
                        len -= stack.pop();
                    }
                }
                int nameEndIndex = readName(index, input);
                String name = input.substring(index, nameEndIndex);
                if (name.contains(".")) {// 'file name'
                    maxTabCount = tableCount - 1;
                    max = Math.max(max, len + name.length());
                } else {
                    maxTabCount = tableCount;
                    len += name.length() + 1;
                    stack.push(name.length() + 1);
                }
                index = nameEndIndex;
                ++index;// '\n'
            }

            return max;
        }

        int readName(int index, String s) {
            while (index < s.length() && s.charAt(index) != '\n') {
                ++index;
            }
            return index;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(32, s.lengthLongestPath(
            "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

        Assert.assertEquals(20,
            s.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

        Assert.assertEquals(0, s.lengthLongestPath("a"));

        Assert.assertEquals(12,
            s.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    }

}
