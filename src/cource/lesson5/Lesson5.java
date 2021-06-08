package cource.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Lesson5 {

    public static void main(String[] args) {
        //1. Написать программу по возведению числа в степень с помощью рекурсии.
        System.out.println(recursivePow(2, 8));


        //2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
        List<PackItem> items = new ArrayList<>();
        items.add(new PackItem("iphone 123",   25, 700_000));
        items.add(new PackItem("eBook",   12, 10_000));
        items.add(new PackItem("vipe",   10, 3_000));
        items.add(new PackItem("notebook",   60, 100_000));
        items.add(new PackItem("vintage camera",   40, 120_000));
        items.add(new PackItem("powerbank",   32, 5_000));
        items.add(new PackItem("nail shelf",   1, 1_000));
        items.add(new PackItem("sunglasses",   2, 25_000));

        BackPack backpack = new BackPack(123);
        backpack.calcBestSet(items);

        backpack.explain();


    }

    public static int recursivePow(int basis, int exponent){
        if (exponent < 0) {
            throw new IllegalArgumentException("negative exponent");
        }
        else if (exponent > 0) {
            return basis * recursivePow(basis, exponent - 1);
        }
        else {
            return 1;
        }
    }
}
