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
    public int getDecimalValue(ListNode head) {
        int num = 0;
        int i=0;
        int l = getLen(head);
        while(head != null) {
            if( head.val == 1)
            num += 1<<(l-i-1);
            i++;
            head = head.next;
        }
        return num;
        
    }
    public int getLen(ListNode head) {
        if( head.next == null) return 1;
        return 1 + getLen(head.next);

    }
}