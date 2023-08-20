package linkedlist;

/**
 * Link: https://leetcode.com/problems/merge-two-sorted-lists
 */
public class MergeSortedLists {
    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(){}
        public ListNode(int value){this.val = value;}
        public ListNode(int value, ListNode next){this.val = value; this.next = next;}
    }
    private ListNode list1;
    private ListNode list2;

    public MergeSortedLists(ListNode list1, ListNode list2){
        this.list1 = list1;
        this.list2 = list2;
    }

    public ListNode mergeTwoLists() {
        //creating a head and a pointer for the result array
        ListNode head = null;
        ListNode ptr = null;
        //initial if conditions to check if any one of the 2 linked lists are empty.
        //if so, return the non empty list.
        if(list1 == null && list2 != null)
            return list2;
        if(list2 == null && list1 != null)
            return list1;
        //iterate the array until end of any of the 2 lists is reached.
        while(list1 != null && list2 != null){
            ListNode node = null;
            //comparison to decide which node needs to be linked
            //also move the pointer of the list by one position.
            if(list1.val > list2.val){
                node = list2;
                list2 = list2.next;
            }
            else{
                node = list1;
                list1 = list1.next;
            }
            //detaching from its list (list1 or list2)
            node.next = null;
            //condition for initial head node assignment.
            if(ptr == null){
                ptr = node;
                head = node;
            }else{
                //assign the next node of ptr to be the node and move the pointer
                ptr.next = node;
                ptr = ptr.next;
            }
        }
        //if conditions to add the remaining portion.
        // cases where length of one list is greater than the other. this will be needed
        //to add the remaining elements.
        if(list1 != null){
            ptr.next = list1;
        }
        if(list2 != null){
            ptr.next = list2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        head1.next = node12;
        node12.next = node13;
        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        head2.next = node22;
        node22.next = node23;
        MergeSortedLists mergeSortedLists = new MergeSortedLists(head1, head2);
        mergeSortedLists.mergeTwoLists();
    }
}
