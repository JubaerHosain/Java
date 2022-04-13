package com.company;

public class Parent {
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayName() {
        System.out.println("Parent name is" + this.name);
    }
}
