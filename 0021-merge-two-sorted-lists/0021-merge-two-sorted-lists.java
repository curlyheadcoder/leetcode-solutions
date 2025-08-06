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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = ans;
        // Traverse till one of the list reaches the end
        while(list1 != null && list2 != null){
            // Compare the 2 values of lists
            if(list1.val <= list2.val){
                ans.next = list1;
                list1 = list1.next;
            }else{
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }
        // Append the remaining list
        if(list1 == null){
            ans.next = list2;
        }else if(list2 == null){
            ans.next = list1;
        }
        // return the next node to dummy node
        return headNode.next;
    }
}