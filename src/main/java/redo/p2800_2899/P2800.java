package redo.p2800_2899;

public class P2800 {

    class Solution {
        public String minimumString(String a, String b, String c) {
            return minimumString(new String[]{a, b, c});
        }

        public String minimumString(String... strings) {
            if (strings.length == 1) {
                return strings[0];
            }
            if (strings.length == 2) {
                String a = strings[0], b = strings[1];
                if (a.contains(b)) {
                    return minimumString(a);
                }
                if (b.contains(a)) {
                    return minimumString(b);
                }
                String ab = contact(a, b);
                String ba = contact(b, a);
                if (ab.length() < ba.length()) {
                    return ab;
                } else if (ab.length() > ba.length()) {
                    return ba;
                } else {
                    if (ab.compareTo(ba) < 0) {
                        return ab;
                    } else {
                        return ba;
                    }
                }
            }
            if (strings.length == 3) {
                String a = strings[0], b = strings[1], c = strings[2];
                if (a.contains(b)) {
                    return minimumString(a, c);
                }
                if (a.contains(c)) {
                    return minimumString(a, b);
                }
                if (b.contains(a)) {
                    return minimumString(b, c);
                }
                if (b.contains(c)) {
                    return minimumString(b, a);
                }
                if (c.contains(a)) {
                    return minimumString(c, b);
                }
                if (c.contains(b)) {
                    return minimumString(c, a);
                }
                String abc = contact(a, b, c);
                String acb = contact(a, c, b);
                String bac = contact(b, a, c);
                String bca = contact(b, c, a);
                String cab = contact(c, a, b);
                String cba = contact(c, b, a);
                String[] arr = new String[]{abc, acb, bac, bca, cab, cba};
                int minLen = Integer.MAX_VALUE;
                String ans = null;
                for (String str : arr) {
                    if (minLen > str.length()) {
                        ans = str;
                        minLen = str.length();
                    } else if (minLen == str.length()) {
                        if (str.compareTo(ans) < 0) {
                            ans = str;
                        }
                    }
                }
                return ans;
            }
            return null;
        }

        public String contact(String... strings) {
            String a = strings[0];
            for (int i = 1; i < strings.length; ++i) {
                a = contact(a, strings[i]);
            }
            return a;
        }

        public String contact(String a, String b) {
            for (int i = Math.min(a.length(), b.length()); i >= 1; --i) {
                if (b.startsWith(a.substring(a.length() - i))) {
                    return a + b.substring(i);
                }
            }
            return a + b;
        }
    }

}
