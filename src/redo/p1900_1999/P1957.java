package redo.p1900_1999;

public class P1957 {

    class Solution {
        public String makeFancyString(String s) {

            char[] chs = s.toCharArray();

            int indexRep = 1;
            int repCount = 1;

            for (int indexNow = 1; indexNow < chs.length; ++indexNow) {
                if (chs[indexNow] == chs[indexNow - 1]) {
                    if (repCount <= 1) {
                        ++repCount;
                        chs[indexRep++] = chs[indexNow];
                    }
                } else {
                    repCount = 1;
                    chs[indexRep++] = chs[indexNow];
                }
            }

            return new String(chs, 0, indexRep);
        }
    }

}
