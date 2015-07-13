/**
 * Created by NicolasTsui on 6/10/15.
 *
 * Nothing special, just need an indicator of 'sum>=10'.
 *
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean extra = false;
        ListNode l0 = new ListNode(0);
        ListNode ptr0 = l0;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        while (ptr1 != null && ptr2 != null) {
            int digit = ptr1.val + ptr2.val;
            if (extra) {
                extra = false;
                digit++;
            }
            if (digit >= 10) {
                digit -= 10;
                extra = true;
            }
            ptr0.next = new ListNode(digit);
            ptr0 = ptr0.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while (ptr1 != null) {
            int digit = ptr1.val;
            if (extra) {
                extra = false;
                digit++;
            }
            if (digit >= 10) {
                digit -= 10;
                extra = true;
            }
            ptr0.next = new ListNode(digit);
            ptr0 = ptr0.next;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            int digit = ptr2.val;
            if (extra) {
                extra = false;
                digit++;
            }
            if (digit >= 10) {
                digit -= 10;
                extra = true;
            }
            ptr0.next = new ListNode(digit);
            ptr0 = ptr0.next;
            ptr2 = ptr2.next;
        }
        if (extra) {
            ptr0.next = new ListNode(1);
        }
        return l0.next;

    }
}
