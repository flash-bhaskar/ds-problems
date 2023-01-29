package BFS;

import java.util.ArrayList;
import java.util.List;

public class Node {

    String name;
    List<Node> neighbors;
    boolean visited = false;
    Node prev = null;

    Node(String name){
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    //Method to connect nodes
    void add_neighbor(Node node){
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

    //leetcode.array.linkedlist.Node representation
    public String toString(){
        return this.name;
    }

}
