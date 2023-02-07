package leetcode.linkedlist;

import java.util.LinkedList;

public class MultiplyLinkedList {

    static class Node
    {
        int data;
        Node next;
        Node(int data) {
            this.data=data;
            this.next = null;
        }
    }

    public static long multiplyLinkedList(Node l1, Node l2) {
        long mod = 1000000007;
        long num1=0, num2 = 0;

        while(l1 != null || l2 != null){
            if(l1 != null){
                num1 = (num1 * 10)%mod + l1.data;
                l1 = l1.next;
            }

            if(l2 != null){
                num2 = (num2 * 10)%mod + l2.data;
                l2 = l2.next;
            }
        }
        return (num1 * num2) % mod;
    }

//    why 10 ^ 9 + 7 is used
//    https://www.geeksforgeeks.org/modulo-1097-1000000007/
    public static void main(String[] args) {
        Node first = new Node(9);
        first.next = new Node(4);
        first.next.next = new Node(6);
        System.out.print("First List is: ");

        // create second list 8->4
        Node second = new Node(8);
        second.next = new Node(4);
        System.out.print("Second List is: ");

        // Multiply the two lists and see result
        System.out.print("Result is: ");
        System.out.println(multiplyLinkedList(first, second));
    }
}
