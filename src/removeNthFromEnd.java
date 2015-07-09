/**
 * Created by NicolasTsui on 7/9/15.
 */
public class RemoveNthFromEnd {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            next=null;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zero=new ListNode(0);
        zero.next=head;
        ListNode ptr=zero;
        ListNode ptr2=head;
        for(int i=0;i<n;i++){
            ptr=ptr.next;
        }
        ListNode last=zero;
        while(ptr.next!=null){
            ptr=ptr.next;
            last=ptr2;
            ptr2=ptr2.next;
        }
        last.next=ptr2.next;
        return zero.next;
    }
}
