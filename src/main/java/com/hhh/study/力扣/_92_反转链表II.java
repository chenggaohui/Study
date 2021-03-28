package com.hhh.study.力扣;

public class _92_反转链表II {




    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode result = head;

        int index = 1;
        ListNode sign = null;
        ListNode pre = null,prePre = null,next = null;
        while (head != null && index <= right){
            if (index == left - 1){
                prePre = head;
            }
            if (index >= left && index <= right){
                next = head.next;
                head.next = pre;
                if (sign == null){
                    sign = head;
                }

            }
            pre = head;
            head = next;
            index++;

        }

        sign.next = next;
        prePre.next = head;
        return result;
    }
}
