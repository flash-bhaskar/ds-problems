package leetcode.linkedlist;

public class SortUnorderedLinkedList {

   static Node head;

    public  void addNode(int  data){
        Node newNode  =  new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        SortUnorderedLinkedList obj = new SortUnorderedLinkedList();
        obj.addNode(9);
        obj.addNode(9);
        obj.addNode(9);
        obj.addNode(8);
        obj.addNode(7);
        obj.addNode(7);
        obj.addNode(6);
        obj.addNode(5);
        obj.addNode(5);
        Node node = obj.removeDuplicates(head);
        System.out.println(node);
    }

    public Node removeDuplicates(Node head){
//        leetcode.array.linkedlist.Node current = head;
//
//        HashSet<Integer> set = new HashSet<>();
//        while(current != null){
//            leetcode.array.linkedlist.Node temp  = current;
//            if(set.contains(current.data)){
//                temp = temp.next;
//            }else{
//                set.add(current.data);
////                prev = current;
//            }
//            current.next = temp;
//            current = current.next;
//        }
//        return head;

        Node temp = head, prev = head;
        while (temp != null) {
            if(temp.data != prev.data){
                prev.next = temp;
                prev =temp;
            }
            temp =temp.next;
        }
        if (prev != temp)
            prev.next = null;
        return head;
    }
}
