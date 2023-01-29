package com.company;

public class Welcome {
    private String greet(String name) {
        if(name == null || name.isEmpty())
            return "Hello Stranger";
        return "Hello " + name;
    }
}
