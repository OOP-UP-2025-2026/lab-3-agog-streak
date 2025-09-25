package org.example.task2;

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart(new Item[10]);
        cart.add(new Item(1, "Samsung Galaxy S23", 27999));
        cart.add(new Item(2, "Lenovo IdeaPad 3", 19499));
        cart.add(new Item(3, "LG 55\" 4K Smart TV", 15999));
        cart.add(new Item(4, "Bosch Serie 6 Пральна машина", 14799));
        cart.add(new Item(5, "Samsung RB34 Холодильник", 22399));
        cart.add(new Item(6, "De'Longhi Magnifica S Кавоварка", 10599));
        cart.add(new Item(7, "Gorenje Електрична плита", 9999));
        cart.add(new Item(8, "Dyson V11 Пилосос", 16499));
        cart.add(new Item(9, "Samsung ME83K Мікрохвильова піч", 3199));
        cart.add(new Item(10, "Philips DryCare Фен", 1499));

        System.out.println(cart);

        cart.removeById(9);

        System.out.println(cart);

        Order order = new Order(1L, "John");
        String bill = order.formOrderBill(cart);
        System.out.println(bill);

        //Box
        try {
            Box box = new Box(3, 4, 5);
            System.out.println("Площа поверхні: " + box.getSurfaceArea());
            System.out.println("Площа бічної поверхні: " + box.getLateralSurfaceArea());
            System.out.println("Об’єм: " + box.getVolume());
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        //IntStack
        IntStack stack = new IntStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Розмір: " + stack.size());    // 3
        System.out.println("Верхній елемент: " + stack.peek()); // 30

        System.out.println("Pop: " + stack.pop()); // 30
        System.out.println("Pop: " + stack.pop()); // 20

        System.out.println("Розмір після pop: " + stack.size()); // 1

        stack.clear();
        System.out.println("Стек порожній? " + stack.isEmpty());
    }
}