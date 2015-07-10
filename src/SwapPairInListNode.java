/**
 * Created by NicolasTsui on 7/10/15.
 */
public class SwapPairInListNode {
    public static ListNode swapPairs(ListNode head) {
        ListNode zero=new ListNode(0);
        zero.next=head;
        ListNode cur=zero;
        ListNode ptr1=null,ptr2=null;
        while(cur.next!=null && cur.next.next!=null){
            ptr1=cur.next;
            ptr2=cur.next.next;
            ptr1.next=ptr2.next;
            ptr2.next=ptr1;
            cur.next=ptr2;
            cur=ptr1;
        }
        return zero.next;
    }
}
