package linkedlist;

import java.util.HashSet;
import java.util.Set;

class ListNode {

    int val;
    ListNode next;

    // Default constructor
    public ListNode() {
    }

    // Constructor to initialize node with a value
    public ListNode(int val) {
        this.val = val;
    }

    // Constructor to initialize node with a value and reference to the next node
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LC3217 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = modifiedList(nums, head);

        ListNode temp = head;

        while (temp.next != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    public static ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        ListNode prev = head;
        ListNode temp = head.next;

        while (temp != null && temp.next != null) {
            if (set.contains(temp.val)) {
                prev.next = temp.next;
            }
            temp = temp.next;
        }

        if (set.contains(head.val)) {
            head = head.next;
        }

        return head;

    }
}
