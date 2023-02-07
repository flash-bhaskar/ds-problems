package leetcode.linkedlist;

public class ListNode {

    int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "leetcode.array.linkedlist.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
