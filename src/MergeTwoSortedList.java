/**
 * Created by NicolasTsui on 7/9/15.
 */
import java.util.*;
public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ptr1=l1;
        ListNode ptr2=l2;
        ListNode zero=new ListNode(0);
        ListNode ptr3=zero;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.val<=ptr2.val){
                ptr3.next=ptr1;
                ptr1=ptr1.next;
            }else{
                ptr3.next=ptr2;
                ptr2=ptr2.next;
            }
            ptr3=ptr3.next;
        }
        while(ptr1!=null){
            ptr3.next=ptr1;
            ptr1=ptr1.next;
            ptr3=ptr3.next;
        }
        while(ptr2!=null){
            ptr3.next=ptr2;
            ptr2=ptr2.next;
            ptr3=ptr3.next;
        }
        return zero.next;
    }
}
