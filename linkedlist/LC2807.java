package linkedlist;

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

public class LC2807 {

    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        // Print the original list (without modifying head)
        ListNode temp = head;  // Use a temporary pointer to print
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        System.out.println();

        // Call the function without modifying head
        ListNode mod = insertGreatestCommonDivisors(head);

        // Print the modified list
        while (mod != null) {  // Traverse mod, starting from the head of the modified list
            System.out.println(mod.val);
            mod = mod.next;
        }
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            int gcd = gcd(prev.val, cur.val);
            ListNode insert = new ListNode(gcd);
            insert.next = cur;
            prev.next = insert;
            prev = cur;
            cur = cur.next;
        }

        return head;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
