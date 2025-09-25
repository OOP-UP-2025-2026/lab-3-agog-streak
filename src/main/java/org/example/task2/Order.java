package org.example.task2;

public class Order {
    private long id;
    private String customer;

    public Order(long id, String customer) {
        this.setId(id);
        this.setCustomer(customer);
    }

    private void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID замовлення має бути більше 0");
        }
        this.id = id;
    }

    private void setCustomer(String customer) {
        if (customer == null || customer.isBlank()) {
            throw new IllegalArgumentException("Ім’я клієнта не може бути пустим");
        }
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {
        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(this.id)
                .append(" for customer ").append(this.customer);
        builder.append("\n------------------\n");

        for (Item item : cart.getItems()) {
            builder.append("Item id: ").append(item.getId())
                    .append(", name: ").append(item.getName())
                    .append(", price: ").append(item.getPrice())
                    .append("\n");
        }

        builder.append("------------------\n");
        builder.append("Total sum: ").append(cart.getTotalPrice());

        return builder.toString();
    }
}
