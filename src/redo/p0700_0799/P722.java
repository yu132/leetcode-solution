package redo.p0700_0799;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName: P722  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月26日  
 *  
 */
public class P722 {

    class Solution {
        public List<String> removeComments(String[] source) {
            int state = 0;// 0 no comment; 1 block

            StringBuilder buf = new StringBuilder(100);

            for (int i = 0; i < source.length; ++i) {

                String line = source[i];

                for (int j = 0; j < line.length(); ++j) {
                    if (state == 0) {
                        if (isLineComment(line, j)) {
                            break;
                        } else if (isBlockComment(line, j)) {
                            state = 1;
                            ++j;
                        } else {
                            buf.append(line.charAt(j));
                        }
                    } else if (state == 1) {
                        if (isReverseBlockComment(line, j)) {
                            state = 0;
                            ++j;
                        }
                    }
                }

                if (state != 1) {
                    buf.append('\n');
                }
            }

            String[] strs = buf.toString().split("\n");

            List<String> ans = new ArrayList<>();

            for (String str : strs) {
                if (!"".equals(str)) {
                    ans.add(str);
                }
            }

            return ans;
        }

        boolean isLineComment(String line, int index) {
            if (index >= line.length() - 1) {
                return false;
            }
            return line.charAt(index) == '/' && line.charAt(index + 1) == '/';
        }

        boolean isBlockComment(String line, int index) {
            if (index >= line.length() - 1) {
                return false;
            }
            return line.charAt(index) == '/' && line.charAt(index + 1) == '*';
        }

        boolean isReverseBlockComment(String line, int index) {
            if (index >= line.length() - 1) {
                return false;
            }
            return line.charAt(index) == '*' && line.charAt(index + 1) == '/';
        }
    }

    // class Solution {
    // public List<String> removeComments(String[] source) {
    //
    // int state = 0;// 0 no comment; 1 block
    //
    // Deque<int[]> stack = new LinkedList<>();
    //
    // List<String> ans = new ArrayList<>();
    //
    //
    // for (int i = 0; i < source.length; ++i) {
    //
    // String line = source[i];
    //
    // int start = -1;
    //
    // if (state == 1) {
    // start = 0;
    // }
    //
    // for (int j = 0; j < line.length(); ++j) {
    // if (state == 0) {
    // if (isLineComment(line, j)) {
    // source[i] = line.substring(0, j);
    // if (isBlank(source[i])) {
    // source[i] = null;
    // }
    // break;
    // } else if (isBlockComment(line, j)) {
    // start = j;
    // state = 1;
    // }
    // } else if (state == 1) {
    // if (isReverseBlockComment(line, j)) {
    // stack.push(new int[] {start, j + 2});
    // ++j;
    // start = -1;
    // state = 0;
    // }
    // }
    // }
    //
    // boolean isDelete = false;
    //
    // if (start != -1) {
    // source[i] = source[i].substring(0, start);
    // isDelete = true;
    // }
    //
    // while (!stack.isEmpty()) {
    // int[] range = stack.pop();
    // source[i] = source[i].substring(0, range[0])
    // + source[i].substring(range[1]);
    // isDelete = true;
    // }
    //
    // if (isDelete) {
    // if (isBlank(source[i])) {
    // source[i] = null;
    // }
    // }
    //
    // if (source[i] != null) {
    // ans.add(source[i]);
    // }
    // }
    //
    // return ans;
    //
    // }
    //
    // boolean isLineComment(String line, int index) {
    // if (index >= line.length() - 1) {
    // return false;
    // }
    // return line.charAt(index) == '/' && line.charAt(index + 1) == '/';
    // }
    //
    // boolean isBlockComment(String line, int index) {
    // if (index >= line.length() - 1) {
    // return false;
    // }
    // return line.charAt(index) == '/' && line.charAt(index + 1) == '*';
    // }
    //
    // boolean isReverseBlockComment(String line, int index) {
    // if (index >= line.length() - 1) {
    // return false;
    // }
    // return line.charAt(index) == '*' && line.charAt(index + 1) == '/';
    // }
    //
    // boolean isBlank(String str) {
    // return str.length() == 0;
    // }
    // }

}
