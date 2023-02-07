package leetcode.linkedlist;

import java.util.ArrayList;

public class IntersectionOfLinkedList {

    static Node head;

    public static void main(String[] args) {
        Node head1, head2;
        head1 = new Node(10);
        head2 = new Node(3);

        Node newNode = new Node(6);
        head2.next = newNode;

        newNode = new Node(9);
        head2.next.next = newNode;

        newNode = new Node(15);
        Node newNode1 = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode1;

        newNode = new Node(30);
        head1.next.next = newNode;

        head1.next.next.next = null;

                  //10 -> 15 -> 30 -> null;
        //3  -> 6 -> 9 -> 15 -> null
        IntersectionOfLinkedList obj  = new IntersectionOfLinkedList();
        Node intersection = obj.getIntersection(head1, head2);
        System.out.println(intersection);
        Node intersectionSortedList = obj.getIntersectionSortedList(head1, head2);
        System.out.println("sorted list " + intersectionSortedList);
    }

    public Node getIntersection(Node head1, Node head2){
        Node ptr1 = head1;
        Node ptr2 = head2;

        while(ptr1 != null){
            Node temp  = ptr2;
            while(temp != null){
                if(temp.data == ptr1.data)
                    return ptr1;
                temp  = temp.next;
            }
            ptr1  = ptr1.next;
        }
        ArrayList<Integer> objects = new ArrayList<>();
        objects.toArray(new Integer[5]);
        return null;
    }

    public Node getIntersectionSortedList(Node head1, Node head2){
        Node ptr1 = head1;
        Node ptr2 = head2;

        while(ptr1 != null && ptr2 != null){
            if(ptr1.data == ptr2.data){
                return ptr1;
            } else if(ptr1.data > ptr2.data){
                ptr2 = ptr2.next;
            } else {
                ptr1 = ptr1.next;
            }
        }
        return null;
    }
}
