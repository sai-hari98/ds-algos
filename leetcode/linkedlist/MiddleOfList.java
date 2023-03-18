package linkedlist;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class MiddleOfList {

    public static ListNode middleNode(ListNode head) {
        int nodesCount = 0;
        ListNode node = head;
        while(node != null){
            nodesCount++;
            node = node.next;
        }

        int middleNode = nodesCount/2;
        nodesCount = 0;
        node = head;
        while(middleNode>nodesCount){
            nodesCount++;
            node = node.next;
        }
        return node;
    }

    public static ListNode middleNodeOptimized(ListNode head) {
        ListNode endNode = head;
        ListNode middleNode = head;
        while(endNode != null && endNode.next != null){
            endNode = endNode.next.next;
            middleNode = middleNode.next;
        }
        return middleNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
