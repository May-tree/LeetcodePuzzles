/**
 * Created by NicolasTsui on 7/10/15.
 */
import java.util.*;
public class MergeSortedKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode zero = new ListNode(0);
        ListNode runner=zero;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            runner.next=queue.poll();
            runner=runner.next;

            if (runner.next!=null)
                queue.add(runner.next);
        }
        return zero.next;
    }
}
