package org.example.task2;

public class Item {
    private long id;
    private String name;
    private double price;

    public Item(long id, String name, double price) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
    }

    // Геттери
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    // Сеттер тільки для валідації (можна зробити private якщо змінювати не треба)
    private void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID товару має бути більше 0");
        }
        this.id = id;
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва товару не може бути пустою");
        }
        this.name = name;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна має бути більшою за 0");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", price=" + this.price +
                '}';
    }

}
