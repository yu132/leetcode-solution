package redo.p0000_0099;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: P20  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P20 {

    class Solution {

        private List<Character> left = Arrays.asList('(', '[', '{');
        // private List<Character> right = Arrays.asList(')', ']', '}');

        public boolean isValid(String s) {
            LinkedList<Character> list = new LinkedList<>();
            for (char ch : s.toCharArray()) {
                if (left.contains(ch)) {
                    push(list, ch);
                } else {// right.contains(ch)
                    char l = pop(list);
                    if (ch - l != 1 && ch - l != 2) {// 使用acsii来判断，使用\0表示空
                        return false;
                    }
                }
            }
            return list.isEmpty();
        }

        public void push(LinkedList<Character> list, Character value) {
            list.addFirst(value);
        }

        public Character pop(LinkedList<Character> list) {
            if (list.isEmpty()) {
                return '\0';
            }
            return list.removeFirst();
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isValid("()"));
        assertTrue(s.isValid("()[]{}"));
        assertTrue(!s.isValid("(]"));
        assertTrue(!s.isValid("([)]"));
        assertTrue(s.isValid("{[]}"));
        assertTrue(s.isValid("([][]{[]{}({[]})})"));
        assertTrue(!s.isValid("}"));
    }

}
