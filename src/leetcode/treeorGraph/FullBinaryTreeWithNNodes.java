package leetcode.treeorGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FullBinaryTreeWithNNodes {
    // Class for creating node and
    // its left and right child
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Function to traverse the tree and add all
    // the left and right child in the list al
    public static void display(Node node, List<Integer> al)
    {
        // If node = null then terminate the function
        if (node == null) {
            return;
        }
        // If there is left child of leetcode.array.linkedlist.Node node
        // then insert it into the list al
        if (node.left != null) {
            al.add(node.left.data);
        }
        // Otherwise insert null in the list
        else {
            al.add(null);
        }

        // Similarly, if there is right child
        // of leetcode.array.linkedlist.Node node then insert it into
        // the list al
        if (node.right != null) {
            al.add(node.right.data);
        }
        // Otherwise insert null
        else {
            al.add(null);
        }

        // Recursively call the function
        // for left child and right child
        // of the leetcode.array.linkedlist.Node node
        display(node.left, al);
        display(node.right, al);
    }
    // Driver Code
    public static void main(String[] args)
    {
        // Given Input
        int n = 7;

        // Function Call
        List<Node> list = allPossibleFBT(n);

        // Print all possible binary full trees
        for (Node root: list) {
            List<Integer> al = new ArrayList<>();
            al.add(root.data);
            display(root, al);
            System.out.println(al);
        }
    }
    // Save tree for all n before recursion.
    static HashMap<Integer, List<Node> > hm = new HashMap<>();
    public static List<Node> allPossibleFBT(int n)
    {
        // Check whether tree exists for given n value or not.
        if (!hm.containsKey(n)) {

            // Create a list containing nodes
            List<Node> list = new LinkedList<>();

            // If N=1, Only one tree can exist
            // i.e. tree with root.
            if (n == 1) {

                list.add(new Node(0, null, null));
            }

            // Check if N is odd because binary full
            // tree has N nodes
            else if (n % 2 == 1) {

                // Iterate through all the nodes that
                // can be in the left subtree
                for (int x = 0; x < n; x++) {

                    // Remaining Nodes belongs to the
                    // right subtree of the node
                    int y = n - 1 - x;

                    // Iterate through all left Full Binary Tree
                    //  by recursively calling the function
                    for (Node left: allPossibleFBT(x)) {

                        // Iterate through all the right Full
                        // Binary tree by recursively calling
                        // the function
                        for (Node right: allPossibleFBT(y)) {

                            // Create a new node
                            Node node = new Node(0, null, null);

                            // Modify the left node
                            node.left = left;

                            // Modify the right node
                            node.right = right;

                            // Add the node in the list
                            list.add(node);
                        }
                    }
                }
            }

            //Insert tree in HashMap.
            hm.put(n, list);
        }
        return hm.get(n);
    }
}
