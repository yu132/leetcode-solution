package redo.p0600_0699;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P690  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    static//

    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> mapping = new HashMap<>();
            for (Employee employee : employees) {
                mapping.put(employee.id, employee);
            }

            FixedArrayStack stack = new FixedArrayStack(employees.size());
            stack.push(id);

            int sum = 0;
            while (!stack.isEmpty()) {
                Employee employee = mapping.get(stack.pop());
                sum += employee.importance;
                for (int subId : employee.subordinates) {
                    stack.push(subId);
                }
            }

            return sum;
        }

        public static class FixedArrayStack {
            int[] stack;
            int index;

            FixedArrayStack(int maxLen) {
                super();
                this.stack = new int[maxLen];
            }

            public void push(int num) {
                stack[index++] = num;
            }

            public int pop() {
                return stack[--index];
            }

            public int peek() {
                return stack[index - 1];
            }

            public boolean isEmpty() {
                return index == 0;
            }
        }
    }

}
