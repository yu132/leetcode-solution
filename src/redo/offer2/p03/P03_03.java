package redo.offer2.p03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P03_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P03_03 {

    class StackOfPlates {

        List<int[]> stacks;
        int cap;

        public StackOfPlates(int cap) {
            stacks = new ArrayList<>();
            this.cap = cap;
        }

        public void push(int val) {
            if (cap == 0) {
                return;
            }
            if (stacks.isEmpty()
                || stacks.get(stacks.size() - 1)[0] == cap + 1) {
                int[] stack = new int[cap + 1];
                stack[0] = 1;
                stacks.add(stack);
            }
            int[] stack = stacks.get(stacks.size() - 1);
            stack[stack[0]++] = val;
        }

        public int pop() {
            if (cap == 0 || stacks.isEmpty()) {
                return -1;
            }
            int[] stack = stacks.get(stacks.size() - 1);
            int val = stack[--stack[0]];
            if (stack[0] == 1) {
                stacks.remove(stacks.size() - 1);
            }
            return val;
        }

        public int popAt(int index) {
            if (cap == 0 || index >= stacks.size()) {
                return -1;
            }
            int[] stack = stacks.get(index);
            int val = stack[--stack[0]];
            if (stack[0] == 1) {
                stacks.remove(index);
            }
            return val;
        }
    }



    @Test
    public void test() {
        StackOfPlates s = new StackOfPlates(2);
        s.push(1);
        s.push(2);
        assertEquals(-1, s.popAt(1));
    }

}
