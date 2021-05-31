package cource.lesson3;

import java.util.ArrayDeque;

/*
3. Создать класс для реализации дека.
 */
public class Lesson3 {

    public static void main(String[] args) {

        String target = "мама мыла раму";
        MyStack stack = new MyStack(target.length());
        char[] result = new char[target.length()];

        for (int i = 0; i < target.length(); i++) {
            stack.push(target.charAt(i));
        }

        for (int i = 0; i < target.length(); i++) {
            result[i] = stack.pop();
        }

        System.out.println(target);
        System.out.println(String.valueOf(result));
    }
}
