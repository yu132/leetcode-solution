package redo.p2200_2299;

public class P2296 {

    class TextEditor {

        StringBuilder buf = new StringBuilder();
        int cursor = 0;

        public TextEditor() {

        }

        public void addText(String text) {
            buf.insert(cursor, text);
            cursor += text.length();
        }

        public int deleteText(int k) {
            int deleteLen = Math.min(k, cursor);
            buf.delete(cursor - deleteLen, cursor);
            cursor -= deleteLen;
            return deleteLen;
        }

        public String cursorLeft(int k) {
            int leftLen = Math.min(k, cursor);
            cursor -= leftLen;
            return preCursor();
        }

        public String cursorRight(int k) {
            int rightLne = Math.min(k, buf.length() - cursor);
            cursor += rightLne;
            return preCursor();
        }

        private String preCursor() {
            if (cursor < 10) {
                return buf.substring(0, cursor);
            } else {
                return buf.substring(cursor - 10, cursor);
            }
        }
    }

}
