package LinkedList;

// ListNode from leetcode
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class LinkedList {

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode iterativeReverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }

    public static void main(String[] args){
        ListNode lnode3 = new ListNode(3);
        ListNode lnode2 = new ListNode(2, lnode3);
        ListNode lnode1 = new ListNode(1, lnode2);

        System.out.println("1. print out linked list");
        printList(lnode1);

        System.out.println("\n2. reverse linked list");
        lnode1 = iterativeReverseList(lnode1);
        printList(lnode1);
    }
}
