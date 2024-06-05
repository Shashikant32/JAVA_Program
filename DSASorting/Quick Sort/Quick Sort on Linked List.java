import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            if (head == null) {
                head = new ListNode(val);
                tail = head;
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }

        head = quickSort(head);
        printList(head);
    }

    static ListNode quickSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Choose pivot as the first element
        ListNode pivot = head;
        ListNode smallerHead = null;
        ListNode greaterHead = null;
        ListNode equalHead = null;

        ListNode current = head;

        // Partition the list into smaller, equal, and greater parts based on the pivot
        while (current != null) {
            ListNode next = current.next;
            if (current.val < pivot.val) {
                current.next = smallerHead;
                smallerHead = current;
            } else if (current.val > pivot.val) {
                current.next = greaterHead;
                greaterHead = current;
            } else {
                current.next = equalHead;
                equalHead = current;
            }
            current = next;
        }

        // Recursively sort smaller and greater parts
        smallerHead = quickSort(smallerHead);
        greaterHead = quickSort(greaterHead);

        // Concatenate smaller, equal, and greater parts
        ListNode sortedList = concatenate(smallerHead, equalHead);
        sortedList = concatenate(sortedList, greaterHead);

        return sortedList;
    }

    static ListNode concatenate(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode current = a;
        while (current.next != null) {
            current = current.next;
        }
        current.next = b;
        return a;
    }

    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
