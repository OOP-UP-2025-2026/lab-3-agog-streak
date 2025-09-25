package org.example.task2;

public class IntStack {
    private int[] elements;   // масив для зберігання елементів
    private int size;         // кількість елементів у стеку
    private static final int DEFAULT_CAPACITY = 10; // початковий розмір масиву

    // Конструктор без параметрів
    public IntStack() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Додає елемент у стек
    public void push(int value) {
        if (this.size == this.elements.length) {
            this.grow(); // якщо масив переповнений → розширюємо
        }
        this.elements[this.size] = value;
        this.size++;
    }

    // Витягує елемент зі стеку
    public int pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Спроба pop() з порожнього стеку!");
        }
        int value = this.elements[this.size - 1];
        this.size--;
        return value;
    }

    // Повертає верхній елемент без видалення
    public int peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Спроба peek() з порожнього стеку!");
        }
        return this.elements[this.size - 1];
    }

    // Повертає кількість елементів у стеку
    public int size() {
        return this.size;
    }

    // Перевірка чи стек порожній
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Очищення стеку
    public void clear() {
        this.size = 0;
    }

    // приватні методи
    // Розширення масиву у 2 рази
    private void grow() {
        int newCapacity = this.elements.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.elements[i];
        }
        this.elements = newArray;
    }
}
