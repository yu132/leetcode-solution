package redo.p2400_2499;

public class P2451 {

    class Solution {
        public String oddString(String[] words) {
            for (int i = 1; i < words[i].length(); ++i) {
                int diff0 = words[0].charAt(i) - words[0].charAt(i - 1),
                        diff1 = words[1].charAt(i) - words[1].charAt(i - 1);
                if (diff0 != diff1) {
                    int diff2 = words[2].charAt(i) - words[2].charAt(i - 1);
                    if (diff0 != diff2) {
                        return words[0];
                    } else {
                        return words[1];
                    }
                }
                for (int j = 2; j < words.length; ++j) {
                    int diff = words[j].charAt(i) - words[j].charAt(i - 1);
                    if (diff0 != diff) {
                        return words[j];
                    }
                }
            }
            return null;
        }
    }

}
