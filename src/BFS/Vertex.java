package BFS;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    public final T data;
    private boolean isVisited = false;
    private List<Vertex<T>> neighbours = new ArrayList<>();
    private Vertex<T> previous;

    public Vertex<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex<T> previous) {
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Vertex<T>> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }

    public Vertex(T data) {
        this.data = data;
    }
}
