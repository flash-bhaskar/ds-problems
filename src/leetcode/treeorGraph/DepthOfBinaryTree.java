package leetcode.treeorGraph;

import java.util.LinkedList;

public class DepthOfBinaryTree {

    public Node root;

    public class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public int findDepthOfTree(Node node){
        int max = 0;
        if (node == null) {
            return max;
        }else {
            int leftNode = 0,rightNode = 0;
            leftNode = findDepthOfTree(node.left);

            rightNode = findDepthOfTree(node.right);
            max = 1 + Math.max(leftNode, rightNode);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8}};

    }
}


