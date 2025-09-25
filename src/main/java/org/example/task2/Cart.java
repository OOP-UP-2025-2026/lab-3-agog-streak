package org.example.task2;

import java.util.Arrays;

public class Cart {
    private Item[] contents;
    private int index; // кількість реально доданих товарів

    public Cart(Item[] contents) {
        if (contents == null || contents.length == 0) {
            throw new IllegalArgumentException("Масив товарів не може бути пустим");
        }
        this.contents = contents;
        this.index = 0;
    }

    public void add(Item item) {
        if (this.isFull()) {
            System.out.println("Кошик переповнений! Неможливо додати товар: " + item.getName());
            return;
        }
        this.contents[this.index] = item;
        this.index++;
    }

    public void removeById(long id) {
        int foundIndex = this.findItemIndexById(id);

        if (foundIndex == -1) {
            System.out.println("Товар з id=" + id + " не знайдено у кошику.");
            return;
        }

        // Зсув масиву вліво
        for (int i = foundIndex; i < this.index - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }

        this.contents[this.index - 1] = null; // останній елемент очищаємо
        this.index--;
    }

    private int findItemIndexById(long id) {
        for (int i = 0; i < this.index; i++) {
            if (this.contents[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Item[] getItems() {
        Item[] actualItems = new Item[this.index];
        for (int i = 0; i < this.index; i++) {
            actualItems[i] = this.contents[i];
        }
        return actualItems;
    }

    public double getTotalPrice() {
        double sum = 0.0;
        for (int i = 0; i < this.index; i++) {
            sum += this.contents[i].getPrice();
        }
        return sum;
    }

    public boolean isFull() {
        return this.index == this.contents.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Cart{\n");
        for (int i = 0; i < this.index; i++) {
            builder.append("  ").append(this.contents[i].toString()).append("\n");
        }
        builder.append("}");
        return builder.toString();
    }
}

