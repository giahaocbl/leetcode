public class TwoPointersSolutions {
    // 141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 876. Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (fast.next == null)
                return slow.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 234. Palindrome Linked List
     public ListNode reverse(ListNode head) {
         ListNode prev = null;
         while (head != null) {
             ListNode tmp = head;
             head = head.next;
             tmp.next = prev;
             prev = tmp;
         }
         return prev;
     }

     public boolean isPalindrome(ListNode head) {
         ListNode slow = head, fast = head;
         ListNode prev = head;
         while (fast != null && fast.next != null) {
             prev = slow;
             slow = slow.next;
             fast = fast.next.next;
         }

         if (fast != null)
             slow = slow.next;

         slow = reverse(slow);
         fast = head;
         while (fast != null && slow != null) {
             if (fast.val != slow.val)
                 return false;
             fast = fast.next;
             slow = slow.next;
         }
         return true;
     }

     // 203. Remove Linked List Elements
     public ListNode removeElements(ListNode head, int val) {
         while (head != null && head.val == val) {
             head = head.next;
         }

         ListNode node = head, prev = head;
         while (node != null) {
             if (node.val == val)
                 prev.next = node.next;
             else
                 prev = node;
             node = node.next;
         }

         return head;
     }

     // 83. Remove Duplicates from Sorted List
     public ListNode deleteDuplicates(ListNode head) {
         if (head == null)
             return head;
         ListNode cur = head.next, prev = head;
         while (cur != null) {
             if (cur.val == prev.val)
                 prev.next = cur.next;
             else
                 prev = cur;
             cur = cur.next;
         }
         return head;
     }

     // 21. Merge Two Sorted Lists
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode curr = new ListNode(-1);
         ListNode root = curr;
         while (list1 != null && list2 != null) {
             if (list1.val < list2.val) {
                 curr.next = list1;
                 list1 = list1.next;
             } else {
                 curr.next = list2;
                 list2 = list2.next;
             }
             curr = curr.next;
         }
         curr.next = list1 == null ? list2 : list1;
         return root.next;
     }
}
