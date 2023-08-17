package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Link: https://leetcode.com/problems/linked-list-cycle
 */
public class LinkedListCycle {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    private ListNode head;

    public LinkedListCycle(ListNode head){
        this.head = head;
    }

    /*
    If a linked list has cycle, then a particular element will be revisited twice.
    Which means, a particular element will not be added into a hashSet on the second attempt. isAdded boolean will return false
    Because same element exist already.
    So, if an element is not getting added, it means the list is in a cycle.
    But space complexity is O(n)
     */
    public boolean hasCycleHashSetMethod(){
        Set<ListNode> hashSet = new HashSet<>();
        while(head != null){
            boolean isAdded = hashSet.add(head);
            if(!isAdded)
                return true;
            head = head.next;
        }
        return false;
    }

    /*
        Cyclic track -> fast and slow runner. Fast runner will overtake the slow runner again at some point.
        If the list has cycle -> a fast pointer will overlap with slow pointer before slow pointer finishes its traversal.
        fast pointer -> moves by 2 nodes. slow pointer -> moves by 1 node
        if fast pointer and slow pointer are same at any point, means the list has a cycle.
        space complexity: O(1). no hashset or anything needed.
     */
    public boolean hasCycleFloydsAlgo(){
        if(head == null || head.next == null)
            return false;
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        do{
            if(slowPtr.next == null ||
                    fastPtr.next == null || fastPtr.next.next == null){
                return false;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }while(fastPtr != slowPtr);
        return true;
    }

    public class Main{
        public static void main(String[] args) {
            ListNode head = new ListNode(3);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(0);
            ListNode node4 = new ListNode(4);
            head.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node2;
            LinkedListCycle linkedListCycle = new LinkedListCycle(head);
            System.out.println(linkedListCycle.hasCycleHashSetMethod());
            System.out.println(linkedListCycle.hasCycleFloydsAlgo());
        }
    }
}
