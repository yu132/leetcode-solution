package redo.p0300_0399;

import java.util.List;

import model.NestedInteger;

/**  
 * @ClassName: P385  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P385 {

    class Solution {
        public NestedInteger deserialize(String s) {
            index = 0;
            this.s = s;
            if (s.charAt(index) == '[') {
                return parseList();
            } else {
                return parseInt();
            }
        }

        int index;
        String s;

        NestedInteger parseList() {
            ++index;// '['
            NestedInteger list = new NestedInteger();

            if (s.charAt(index) == ']') {
                ++index;// ']'
                return list;
            }

            do {
                if (s.charAt(index) == ',') {
                    ++index;
                }
                if (s.charAt(index) == '[') {
                    list.add(parseList());
                } else {
                    list.add(parseInt());
                }
            } while (s.charAt(index) == ',');
            ++index;// ']'
            return list;
        }

        NestedInteger parseInt() {
            int sign = 1;
            if (s.charAt(index) == '-') {
                sign = -1;
                ++index;// '-'
            }
            int num = 0;
            while (index < s.length() && s.charAt(index) != ','
                && s.charAt(index) != ']') {
                num = num * 10 + s.charAt(index++) - '0';
            }
            return new NestedInteger(sign * num);
        }
    }

}
