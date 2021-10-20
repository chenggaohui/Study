package com.hhh.study.力扣;

public class _328_奇偶链表 {



    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = oddEvenList(listNode1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode leftHead = head;
        ListNode left = head;
        ListNode rightHead = head.next;
        ListNode right = head.next;
        boolean sign = true;
        head = head.next.next;
        while (head != null){

            if (sign){
                left.next = head;
                left = left.next;
                sign = !sign;
            }else {
                right.next = head;
                right = right.next;
                sign = !sign;
            }
            head = head.next;
        }
        left.next = rightHead;
        right.next = null;
        return leftHead;
    }

}
