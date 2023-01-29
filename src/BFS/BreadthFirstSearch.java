package BFS;

import java.util.*;

public class BreadthFirstSearch<T> {

    private Vertex<T> vertex;

    public BreadthFirstSearch(Vertex<T> vertex) {
        this.vertex = vertex;
    }

    public BreadthFirstSearch(){

    }


    public void traverse(){
        Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
        queue.add(vertex);
        while(!queue.isEmpty()){
            Vertex<T> currentNode = queue.poll();
            if(!currentNode.isVisited()){
                currentNode.setVisited(true);
                System.out.println("visited vertex " + currentNode.getData());
                queue.addAll(currentNode.getNeighbours());
            }
        }
    }

    public void findShortestPath(Vertex<T> start, Vertex<T> end){
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            Vertex<T> currentNode = queue.poll();
            if(!currentNode.isVisited()){
                currentNode.setVisited(true);
                currentNode.getNeighbours().forEach(node -> node.setPrevious(currentNode));
                queue.addAll(currentNode.getNeighbours());
            }
            if(currentNode.getData() == end.getData()){
                queue.clear();
            }
        }
        traceRoute(end);
    }

    private void traceRoute(Vertex<T> end) {
        Vertex<T> vertex = end;
        List<T> route = new ArrayList<>();
        while(vertex != null){
            route.add(vertex.getData());
            vertex = vertex.getPrevious();
        }
        Collections.reverse(route);
        System.out.println(route);
    }

    public static void main(String[] args) {
        Vertex<Integer> v1 = new Vertex<>(0);
        Vertex<Integer> v2 = new Vertex<>(1);
        Vertex<Integer> v3 = new Vertex<>(2);
        Vertex<Integer> v4 = new Vertex<>(3);
        Vertex<Integer> v5 = new Vertex<>(4);
        Vertex<Integer> v6 = new Vertex<>(5);
        Vertex<Integer> v7 = new Vertex<>(6);

        v1.setNeighbours(Arrays.asList(v2, v6, v7));
        v2.setNeighbours(Arrays.asList(v3, v4));
        v4.setNeighbours(Arrays.asList(v5));
        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(v1);
//        bfs.traverse();

        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");

        A.setNeighbours(Arrays.asList(B));
        B.setNeighbours(Arrays.asList(C, E));
        C.setNeighbours(Arrays.asList(D));
        D.setNeighbours(Arrays.asList(E));
        BreadthFirstSearch<String> bfs1 = new BreadthFirstSearch<>();
        bfs1.findShortestPath(A, D);
    }
}
