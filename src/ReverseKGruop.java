/**
 * Created by NicolasTsui on 7/10/15.
 */
public class ReverseKGruop {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return head;
        }
        ListNode zero=new ListNode(0);
        ListNode cur=zero;
        zero.next=head;
        ListNode newstart,tail,start,end,nextStart;
        while(cur.next!=null) {
            end = cur;
            start = cur.next;
            //move 'end' to the kth position
            for (int i = 0; i < k; i++) {
                if (end.next == null) {
                    return zero.next;
                }
                end = end.next;
            }
            nextStart = end.next;
            tail = cur.next;
            for (int i = 0; i < k - 1; i++) {
                cur.next = start.next;
                start.next = end.next;
                end.next = start;
                start = cur.next;
            }
            tail.next = nextStart;
            cur = tail;
        }
        return zero.next;
    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        ListNode newHead=reverseKGroup(head,3);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }
}
