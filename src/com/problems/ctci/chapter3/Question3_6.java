package com.problems.ctci.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Question3_6 {

    public class AnimalShelter {

        Deque<Cat> catQueue;
        Deque<Dog> dogQueue;
        int order;
        int size;

        public AnimalShelter() {
            catQueue = new ArrayDeque<>();
            dogQueue = new ArrayDeque<>();
        }

        public void enqueue(Animal a) {
            if (a == null) return;
            if (a instanceof Dog) dogQueue.offerLast((Dog) a);
            else catQueue.offerLast((Cat) a);
            a.setOrder(order);
            order++;
            size++;
        }


        public Dog dequeueDog() {
            if (dogQueue.isEmpty()) throw new NoSuchElementException();
            size--;
            return dogQueue.pollFirst();
        }

        public Cat dequeueCat() {
            if (catQueue.isEmpty()) throw new NoSuchElementException();
            size--;
            return catQueue.pollFirst();
        }

        public Animal dequeueAny() {
            if (dogQueue.isEmpty()) return dequeueCat();
            else if (catQueue.isEmpty()) return dequeueDog();
            else {
                Dog d = dogQueue.peekFirst();
                Cat c = catQueue.peekFirst();
                if (d.order < c.order) return dequeueDog();
                else return dequeueCat();
            }
        }
    }

    private static class Animal {
        public String name;
        public int order; // acts as timestamp

        public Animal(String name) {
            this.name = name;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }
    }

    private static class Dog extends Animal {
        String name;

        public Dog(String name) {
            super(name);
        }
    }

    public static class Cat extends Animal {
        String name;

        public Cat(String name) {
            super(name);
        }
    }

}
