package redo.p1100_1199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P1106 {

    class Solution {
        public boolean parseBoolExpr(String expression) {
            LinkedList<Character> numStack = new LinkedList<>();
            LinkedList<Character> opStack = new LinkedList<>();

            for (char c : expression.toCharArray()) {
                if (c == '!' || c == '|' || c == '&') {
                    opStack.push(c);
                } else if (c == '(') {
                    numStack.push(c);
                } else if (c == 'f' || c == 't') {
                    numStack.push(c);
                } else if (c == ')') {
                    char op = opStack.pop();
                    if (op == '!') {
                        char num = numStack.pop();
                        numStack.pop();// "("
                        numStack.push(not(num));
                    } else {
                        List<Character> nums = new ArrayList<>();
                        while (numStack.peek() != '(') {
                            nums.add(numStack.pop());
                        }
                        numStack.pop();// "("
                        if (op == '|') {
                            numStack.push(or(nums));
                        } else {
                            numStack.push(and(nums));
                        }
                    }
                }
            }

            if (numStack.peek() == 't') {
                return true;
            } else {
                return false;
            }
        }

        char not(char ch) {
            if (ch == 'f') {
                return 't';
            } else {
                return 'f';
            }
        }

        char and(List<Character> list) {
            for (char ch : list) {
                if (ch == 'f') {
                    return 'f';
                }
            }
            return 't';
        }

        char or(List<Character> list) {
            for (char ch : list) {
                if (ch == 't') {
                    return 't';
                }
            }
            return 'f';
        }
    }

}
