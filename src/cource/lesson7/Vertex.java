package cource.lesson7;

import java.util.Objects;

public class Vertex<E> {

    private final E data;
    private boolean visited;
    private Vertex previousVertex;

    public Vertex(E data) {
        this.data = data;
        this.visited = false;
    }

    public E getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + data.toString() + '\'' +
                '}';
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }
}
