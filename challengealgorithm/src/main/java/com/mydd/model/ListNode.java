package com.mydd.model;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    @Override
    public boolean equals(Object a) {
        if (a == null) return false;
        ListNode next0 = this, next1 = (ListNode) a;
        while(next0 != null && next1 != null) {
            if(next0.val == next1.val) {
                next0 = next0.next;
                next1 = next1.next;
            } else {
                return false;
            }
        }
        return next0 == null && next1 == null;
    }
}
