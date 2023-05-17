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

    public static void main(String[] args){
        ListNode lnode3 = new ListNode(3);
        ListNode lnode2 = new ListNode(2, lnode3);
        ListNode lnode1 = new ListNode(1, lnode2);

        printList(lnode1);
    }
}
