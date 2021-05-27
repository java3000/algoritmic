package cource.lesson2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Lesson2 {

    private final static int MAX_SIZE = 100_000;

    public static void main(String[] args) {

        //1. Создать массив большого размера (миллион элементов).
        MyArray array = new MyArray(MAX_SIZE);

        //3. Заполнить массив случайными числами.
        for (int i = 0; i < array.getSize(); i++) {
            array.insert(new Random().nextInt(10));
        }

        measure(array::sortBubble);
        measure(array::sortInsert);
        measure(array::sortSelect);
    }

    //4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
    public static void measure(Worker action){
        long start = System.nanoTime();
        action.work();
        long end = System.nanoTime();
        System.out.println("завершено за " + TimeUnit.NANOSECONDS.toMillis(end - start) + " мс");
    }
}
