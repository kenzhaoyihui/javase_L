package lettcode1_10.add_two_numbers;

public class AddTwoNumbers {
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//
//        int carry = 0;
//        while (p!=null || q!=null ) {
//            int x = (p!=null) ? p.data:0;
//            int y = (q!=null) ? q.data:0;
//            int sum = carry +x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum%10);
//            curr = curr.next;
//
//            if(p!=null) p=p.next;
//            if(q!=null) q=q.next;
//        }
//
//        if (carry>0){
//            curr.next = new ListNode(carry);
//        }
//
//        return dummyHead.next;
//    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode dumm = new ListNode(0);
        ListNode p=l1, q=l2, curr=dumm;

        int carry=0;
        while (p!=null || q!=null){
            int x = (p!=null)?p.data:0;
            int y = (q!=null)?q.data:0;
            int sum = carry + x + y;
            carry = sum /10;

            curr.next = new ListNode(sum%10);
            curr = curr.next;

            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }

        if (carry>0){
            curr.next = new ListNode(carry);
        }

        return dumm.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode dummy = addTwoNumbers1(l1, l2);
        System.out.println(dummy.data);
        System.out.println(dummy.next.data);
        System.out.println(dummy.next.next.data);
        System.out.println(dummy.next.next.next.data);

    }
}

class ListNode {
    protected ListNode next;
    public int data;

    public ListNode(int data){
        this.data = data;
    }
}
