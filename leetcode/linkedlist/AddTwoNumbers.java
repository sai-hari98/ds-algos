/*
package linkedlist;

public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode l1;
    private ListNode l2;

    public static ListNode createLinkedList(int[] numbers, int index){
        if(index == numbers.length)
            return null;
        ListNode node = new ListNode(numbers[index]);
        node.next = createLinkedList(numbers, index+1);
        return node;
    }

    public AddTwoNumbers(ListNode l1, ListNode l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    public static void main(String[] args) {
//        AddTwoNumbers addTwoNumbers = new AddTwoNumbers(ListNode.)
    }

    public ListNode addTwoNumbersRecursion() {
        return addNums(l1,l2,0);
    }

    public ListNode addNums(ListNode l1, ListNode l2, int carryOver){
        if(l1 == null && l2 == null){
            return carryOver != 0 ? new ListNode(carryOver) : null;
        }
        int value1 = l1 != null ? l1.val : 0;
        int value2 = l2 != null ? l2.val : 0;
        int sum = value1+value2+carryOver;
        ListNode node = new ListNode(sum%10);
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
        node.next = addNums(l1,l2,sum/10);
        return node;
    }

    */
/* Why this approach runtime is way slower *//*

    public ListNode addTwoNumbersInefficient() {
        ListNode head = null, pointer = null;
        int carryForward = 0;
        while(l1 != null && l2 != null){
            int valueInList1 = l1.val;
            int valueInList2 = l2.val;
            int sum = carryForward+valueInList1+valueInList2;
            int remainder = sum%10;
            carryForward = sum/10;
            ListNode node = new ListNode(remainder);
            if(head == null){
                head = node;
                pointer = node;
            }else{
                pointer.next = node;
                pointer = pointer.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int valueInList = l1.val;
            int sum = carryForward + valueInList;
            int remainder = sum%10;
            carryForward = sum/10;
            ListNode node = new ListNode(remainder);
            pointer.next = node;
            pointer = pointer.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int valueInList = l2.val;
            int sum = carryForward + valueInList;
            int remainder = sum%10;
            carryForward = sum/10;
            ListNode node = new ListNode(remainder);
            pointer.next = node;
            pointer = pointer.next;
            l2 = l2.next;
        }
        */
/* Java is always pass by value. Changes in the pointer won't affect
        in parent method
        // carryForward = copyValuesFromList(l1, carryForward, pointer);
        // carryForward = copyValuesFromList(l2, carryForward, pointer;        *//*

        System.out.println(pointer);
        if(carryForward != 0){
            ListNode node = new ListNode(carryForward);
            pointer.next = node;
        }
        return head;

    }

*/
/*    public int copyValuesFromList(ListNode list, int carryForward, ListNode pointer){
        while(list != null){
            System.out.println("inside condition");
            int valueInList = list.val;
            int sum = carryForward + valueInList;
            System.out.println(sum);
            int remainder = sum%10;
            carryForward = sum/10;
            ListNode node = new ListNode(remainder);
            pointer.next = node;
            pointer = pointer.next;
            list = list.next;
        }
        return carryForward;
    }*//*


}
*/
