package redo.zhousai;

public class P6095 {

    class Solution {
        public boolean strongPasswordCheckerII(String password) {
            if (password.length() < 8) {
                return false;
            }
            int cl = 0, cu = 0, cn = 0, csp = 0;

            String sp = "!@#$%^&*()-+";

            for (char ch : password.toCharArray()) {
                if (Character.isLowerCase(ch)) {
                    ++cl;
                } else if (Character.isUpperCase(ch)) {
                    ++cu;
                } else if (Character.isDigit(ch)) {
                    ++cn;
                } else if (sp.contains(ch + "")) {
                    ++csp;
                }
            }

            if (cl == 0 || cu == 0 || cn == 0 || csp == 0) {
                return false;
            }

            for (int i = 1; i < password.length(); ++i) {
                if (password.charAt(i) == password.charAt(i - 1)) {
                    return false;
                }
            }

            return true;
        }
    }

}
