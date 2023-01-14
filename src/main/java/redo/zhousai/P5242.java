package redo.zhousai;

public class P5242 {

    class Solution {
        public String greatestLetter(String s) {
            boolean[][] arr = new boolean[26][2];
            for (char ch : s.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    arr[ch - 'A'][0] = true;
                } else {
                    arr[ch - 'a'][1] = true;
                }
            }
            for (int i = 25; i >= 0; --i) {
                if (arr[i][0] && arr[i][1]) {
                    return (char) (i + 'A') + "";
                }
            }
            return "";
        }
    }

}
