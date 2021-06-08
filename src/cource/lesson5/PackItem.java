package cource.lesson5;

import java.util.Objects;

public class PackItem {
    private final String name;
    private final int weight;
    private final int price;

    public PackItem(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackItem)) return false;
        PackItem packItem = (PackItem) o;
        return weight == packItem.weight && price == packItem.price && name.equals(packItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price);
    }
}
