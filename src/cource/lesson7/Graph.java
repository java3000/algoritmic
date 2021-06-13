package cource.lesson7;

import cource.lesson3.MyStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Graph<E> {

    private final List<Vertex<E>> vertices;
    private final boolean[][] adjMat;

    public Graph(List<Vertex<E>> vertices) {
        this.vertices = vertices;
        this.adjMat = new boolean[vertices.size()][vertices.size()];
    }

    public Graph(int size) {
        this.vertices = (List<Vertex<E>>) new ArrayList<E>();
        this.adjMat = new boolean[size][size];
    }

    public void addVertex(E data) {
        vertices.add(new Vertex<E>(data));
    }

    public boolean addEdge(E start, E second, E... others) {
        boolean result = addEdge(start, second);
        for (E another : others) {
            result &= addEdge(start, another);
        }
        return result;
    }

    private boolean addEdge(E start, E end) {
        int startIndex = indexOf(start);
        int endIndex = indexOf(end);

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;
        return true;
    }

    public int getSize() {
        return vertices.size();
    }

    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertices.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertices.get(j));
                }
            }
            System.out.println();
        }
    }

    private int indexOf(E data) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex vertex = vertices.get(i);
            if (vertex.getData().equals(data)) {
                return i;
            }
        }

        return -1;
    }

    private void resetVertexState() {
        for (Vertex vertex : vertices) {
            vertex.setVisited(false);
            vertex.setPreviousVertex(null);
        }
    }

    private void visitVertex(MyStack<Vertex> stack, Vertex vertex) {
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        queue.add(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNearUnvisitedVertex(Vertex current) {
        int currentIndex = vertices.indexOf(current);
        for (int i = 0; i < getSize(); i++) {
            if (adjMat[currentIndex][i] && !vertices.get(i).isVisited()) {
                return vertices.get(i);
            }
        }
        return null;
    }

    public void dfs(E data) {
        int startIndex = indexOf(data);

        MyStack<Vertex> stack = new MyStack<>();
        Vertex vertex = vertices.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        resetVertexState();
    }

    public MyStack<E> findShortPath(E start, E finish) {
        MyStack<E> path = new MyStack<>();

        int startIndex = indexOf(start);
        Queue<Vertex> queue = new ArrayDeque<>();

        Vertex vertex = vertices.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
            } else {
                visitVertex(queue, vertex);
                vertex.setPreviousVertex(queue.peek());
                if (vertex.getData().equals(finish)) {
                    path = buildPath(vertex);
                }
            }
        }

        resetVertexState();
        return path;
    }

    private MyStack<E> buildPath(Vertex vertex) {
        MyStack<E> stack = new MyStack<>();
        Vertex current = vertex;
        while (current != null) {
            stack.push((E) current.getData());
            current = current.getPreviousVertex();
        }

        return stack;
    }
}
