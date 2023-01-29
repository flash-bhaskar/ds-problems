package BFS;

import java.util.Arrays;
import java.util.Stack;

public class DepthFirstSearch<T> {

    public void traverse(Vertex<T> vertex){
        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(vertex);
        while(!stack.empty()){
            Vertex<T> currentNode = stack.pop();
            if(!currentNode.isVisited()){
                currentNode.setVisited(true);
                System.out.println("visited node " + currentNode.getData());
                currentNode.getNeighbours().forEach(stack::push);
            }
        }
    }

    public void traverseRecursively(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println("traverseRecursively node " + vertex.getData());
        vertex.getNeighbours().stream().filter(node -> !node.isVisited())
                .forEach(this::traverseRecursively);
    }

    public static void main(String[] args) {
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");
        Vertex<String> G = new Vertex<>("G");

        A.setNeighbours(Arrays.asList(B, F, G));
        B.setNeighbours(Arrays.asList(C, E));
        C.setNeighbours(Arrays.asList(D));
        D.setNeighbours(Arrays.asList(E));

        DepthFirstSearch<String> dfs = new DepthFirstSearch<>();
//        dfs.traverse(A);
        dfs.traverseRecursively(A);
    }
}
