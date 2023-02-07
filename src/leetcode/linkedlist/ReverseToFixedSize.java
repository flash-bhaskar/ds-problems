package leetcode.linkedlist;

public class ReverseToFixedSize {

    Node head;

    public static void main(String[] args) {
        ReverseToFixedSize  obj = new ReverseToFixedSize();
//        obj.addNode(9);
//        obj.addNode(8);
//        obj.addNode(7);
//        obj.addNode(6);
//        obj.addNode(5);
        obj.addNode(4);
        obj.addNode(3);
        obj.addNode(2);
        obj.addNode(1);
//                l1.next = new leetcode.array.linkedlist.Node(2);
//        l1.next.next = new leetcode.array.linkedlist.Node(1);
//        l1.next.next.next = new leetcode.array.linkedlist.Node(4);
//        l1.next.next.next.next = new leetcode.array.linkedlist.Node(6);
//        l1.next.next.next.next.next = new leetcode.array.linkedlist.Node(5);
        Node node = obj.reverseToFixesSize(obj.head, 3);
        System.out.println(node);
    }

    public  void addNode(int  data){
        Node newNode  =  new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public Node reverseToFixesSize(Node head, int size){
        if(head ==  null)
            return null;

        Node current = head;
        Node prev = null;
        Node next = null;

        int count =  0;
        while(count < size && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next != null)
            head.next = reverseToFixesSize(next,size);

        return prev;
    }
}
