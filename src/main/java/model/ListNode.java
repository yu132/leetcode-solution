package model;

import redo.testUtil.LinkedListTestUtil;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return LinkedListTestUtil.toStr(this);
    }
}
