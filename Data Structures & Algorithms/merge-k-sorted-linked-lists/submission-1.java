/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length > 0) {
            ListNode head = null;
            ListNode temp = null;
            for (int j = 0; j != lists.length; j = 0) {
                int minIndeks = -1;
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] != null) {
                        if (minIndeks == -1 || lists[i].val < lists[minIndeks].val) {
                            minIndeks = i;
                        }
                    } else {
                        j++;
                    }
                }
                if (j == lists.length) {
                    break;
                }
                if (head == null) {
                    head = new ListNode(lists[minIndeks].val);
                    temp = head;
                } else {
                    ListNode newNode = new ListNode(lists[minIndeks].val);
                    temp.next = newNode;
                    temp = temp.next;
                }
                lists[minIndeks] = lists[minIndeks].next;
            }
            return head;
        }
        return null;
    }
}
