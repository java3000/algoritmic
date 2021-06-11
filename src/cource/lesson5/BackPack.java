package cource.lesson5;

import java.util.ArrayList;
import java.util.List;

public class BackPack {

    private final int maxWeight;

    private int bestPrice;
    private List<PackItem> bestSet = null;

    public BackPack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int calcWeight(List<PackItem> items) {
        int weight = 0;
        for (PackItem item : items) weight += item.getWeight();
        return weight;
    }

    private int calcPrice(List<PackItem> items) {
        int price = 0;
        for (PackItem item : items) price += item.getPrice();
        return price;
    }

    public void calcBestSet(List<PackItem> items) {
        //calcBestSet(items);
        int price = calcPrice(items);
        int weight = calcWeight(items);
        if (weight <= maxWeight && price > bestPrice) {
            bestSet = items;
            bestPrice = price;
        }

        for (int i = 0; i < items.size(); i++) {
            List<PackItem> temp = new ArrayList<>(items);
            temp.remove(i);
            calcBestSet(temp);
        }
    }

    public void explain(){
        System.out.println("Лучший набор ");
        for (PackItem item : bestSet) {
            System.out.println(item.getName() + " " + item.getPrice());
        }
        System.out.println("Общая цена " + bestPrice);
        System.out.println("Общий вес " + calcWeight(bestSet) + " из "  + maxWeight);
    }
}
