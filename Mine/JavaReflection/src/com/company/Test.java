package com.company;

@FunctionalInterface
public interface Test {
    public abstract void showValue();
    // can not declare multiple method bcz of functional Interface annotation
    // public abstract void setValue();
}
