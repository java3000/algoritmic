package cource.lesson7;

import cource.lesson3.MyStack;

public class Lesson7 {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Тамбов");
        graph.addVertex("Липецк");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва","Тула");
        graph.addEdge("Москва","Калуга");
        graph.addEdge("Москва","Рязань");
        graph.addEdge("Тула","Липецк");
        graph.addEdge("Рязань","Тамбов");
        graph.addEdge("Калуга","Орел");
        graph.addEdge("Липецк","Воронеж");
        graph.addEdge("Тамбов","Саратов");
        graph.addEdge("Орел","Курск");
        graph.addEdge("Саратов","Воронеж");
        graph.addEdge("Курск","Воронеж");

        MyStack<String> path = graph.findShortPath("Москва", "Воронеж");

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while (!path.isEmpty()) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(path.pop());
        }

        System.out.println(sb);
    }
}
