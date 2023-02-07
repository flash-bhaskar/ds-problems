package leetcode.linkedlist;

public class DetectAndRemoveLoopLinedList {

//    static leetcode.array.linkedlist.Node head;
    public static void main(String[] args) {
        DetectAndRemoveLoopLinedList obj = new DetectAndRemoveLoopLinedList();
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
//        obj.head.next = obj.head.next.next.next;

        head.next.next.next.next.next = head.next.next;
        System.out.println(head);
        removeLoopSimple(head);
        System.out.println("qw");
    }

//    public  void addNode(int  data){
//        leetcode.array.linkedlist.Node newNode  =  new leetcode.array.linkedlist.Node(data);
//        newNode.next = head;
//        head = newNode;
//    }


    public static void removeLoopSimple(Node node){
        Node slow = node;
        Node fast = node;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                removeLinkedList(slow);
            }
        }
    }

    private static void removeLinkedList(Node node) {
        Node ptr1 = node;
        Node ptr2 = node;
        Node prevNode = ptr1;
        while(ptr1.next != ptr2){
            prevNode = ptr1;
            ptr1 = ptr1.next;
        }
        prevNode.next = null;
        System.out.println("removed list " + prevNode);
    }


    public static void removeLoop(Node head){
        // code here
        Node slow = head;
        Node fast = head;

        while(slow != null && fast != null && fast.next != null){
            //slow will move 1 step at a time like tortoise
            slow = slow.next;
            //fast will move 2 step at a   time like a rabbit,if the linked list is  circle  definetly at some time they will meet
            fast = fast.next.next;

            if(slow == fast){
                //initialize the meeting point  to pointers
                Node ptr1 = slow;
                Node ptr2 = slow;

                //count the number of nodes in the loop
                int k = 1, i;
                while (ptr1.next != ptr2) {
                    ptr1 = ptr1.next;
                    k++;
                }

                //after counting the nodes in loop, reset  the linedlist back to head
                ptr1 = head;
                ptr2 = head;

               //move the ptr2 nodes k nodes after the node
                for (i = 0; i < k; i++) {
                    ptr2 = ptr2.next;
                }

                //iterate  both pointers at same phase, they will meet  starting node of loop
                while (ptr2 != ptr1) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }

                //this is to find the  end node of the loop
                while (ptr2.next != ptr1) {
                    ptr2 = ptr2.next;
                }
                //once end node is found make it null
                ptr2.next = null;
            }
        }

    }
}
