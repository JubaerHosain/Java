package com.company;

public class Child extends Parent implements Test {
    private int value;

    public Child(String name, int value) {
        super(name);
        this.value = value;
    }

    @Override
    public void showValue() {
        System.out.println("Child value is: " + this.value);
    }

    @Deprecated
    public void doNotUseIt() {
        System.out.println("Don't use it.");
    }
}
