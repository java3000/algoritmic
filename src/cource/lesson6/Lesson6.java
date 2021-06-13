package cource.lesson6;

import java.util.Random;

public class Lesson6 {
    public static void main(String[] args) {
        Random rand = new Random();
        int treeCount = 20;
        int maxLevel = 4;
        int nodeCount = (int) (Math.pow(2, maxLevel) - 1);
        int maxValue = 100;
        int balancedTreeCount = 0;
        boolean treeView = false;

        for (int i = 0; i < treeCount; i++) {
            Tree<Integer> theTree = new Tree<>(maxLevel);
            initTree(rand, nodeCount, maxValue, theTree);
            if (theTree.isBalanced()) {
                balancedTreeCount++;
                if (!treeView) {
                    treeView = true;
                    theTree.display();
                }
            }
        }

        System.out.println("% of Balanced= " + ((balancedTreeCount / (treeCount * 1.0)) * 100));
    }

    private static void initTree(Random rand, int nodeCount, int maxValue, Tree<Integer> theTree) {
        for (int j = 0; j < nodeCount; j++) {
            theTree.add(rand.nextInt(maxValue * 2 + 1) - maxValue);
        }
    }
}
