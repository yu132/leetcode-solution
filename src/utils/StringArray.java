package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: StringArray  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月5日  
 *  
 */
public class StringArray {

    public static List<String> valueOf(String str) {
        str = str.substring(1, str.length() - 1);
        String[]     sp  = str.split(",");

        List<String> ans = new ArrayList<>();
        for (String each : sp) {
            each = each.substring(1, each.length() - 1);
            ans.add(each);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Different.different(valueOf(
            "[\"()()()()\",\"(()())()\",\"(()(()))\",\"()()(())\",\"(((())))\",\"(())()()\",\"()((()))\",\"()(())()\",\"()(()())\",\"(()()())\",\"((()()))\",\"((()))()\",\"((())())\"]"),
            valueOf(
                "[\"(((())))\",\"((()()))\",\"((())())\",\"((()))()\",\"(()(()))\",\"(()()())\",\"(()())()\",\"(())(())\",\"(())()()\",\"()((()))\",\"()(()())\",\"()(())()\",\"()()(())\",\"()()()()\"]"))));
    }

}
