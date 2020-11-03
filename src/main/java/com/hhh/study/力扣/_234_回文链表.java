package com.hhh.study.力扣;

public class _234_回文链表 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode next = this.next;
            while(next != null){
                sb.append("->").append(next.val);
                next = next.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        head.next = node2;
        boolean result = isPalindrome(head);
        System.out.println(result);
    }

    public static boolean isPalindrome(ListNode head){
        System.out.println(head.toString());
        System.out.println("**************");
        if (head == null || head.next == null){
            return true;
        }
        if (head.next.next == null){
            return head.val == head.next.val;
        }

        ListNode right = head.next.next;

        ListNode left = head;
        head = head.next;
        left.next = null;
        ListNode temp = left;
        boolean signHead = true;
        boolean signRight = true;
        while(right!=null){
            System.out.println("HEAD:"+head.toString());
            System.out.println("TEMP:"+temp.toString());

            head.next = left;

            if (temp != null && temp.val == head.val && signHead){
                System.out.println("跟谁匹配：头");
                temp = temp.next;
                signRight = false;
            }else if (temp != null && temp.val == right.val && signRight){
                System.out.println("跟谁匹配：右");
                temp = temp.next;
                signHead = false;
            }else{
                System.out.println("下一次~~~~~~~~~~");
                left = head;
                temp = left;
                signHead = true;
                signRight = true;
            }
            head = right;
            right = head.next;
            System.out.println("--------------------");
        }
        return temp == null;
    }


}
