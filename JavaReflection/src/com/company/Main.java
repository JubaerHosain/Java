package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    private static void initial() throws ClassNotFoundException {
        // entry point of reflection API
        Class<?> cl = Class.forName("com.company.Person");

        System.out.println("Class name: " + cl.getName());

        System.out.println("Getting constructors of a class.........");
        Constructor<?>[] constructors = cl.getConstructors();
        System.out.println("Constructors are: " + Arrays.toString(constructors));

        System.out.println("Getting methods(even super class) of a class.........");
        Method[] methods = cl.getMethods();
        System.out.println("Methods are: " + Arrays.toString(methods));

        Method[] declaredMethods = cl.getDeclaredMethods();
        System.out.println("Declared methods are: " + Arrays.toString(declaredMethods));


        System.out.println("Getting fields of a class.........");
        Field[] fields = cl.getFields();
        System.out.println("Fields are: " + Arrays.toString(fields));

        Field[] declaredFields = cl.getDeclaredFields();
        System.out.println("Fields are: " + Arrays.toString(declaredFields));
    }

    private static void metadata() throws ClassNotFoundException {
        Class<?> cl = Class.forName("com.company.Child");

//        System.out.println("Class name: " + cl.getName());
//        System.out.println("Class name: " + cl.getSimpleName());
//
//        System.out.println("Super class: " + cl.getSuperclass());
//        System.out.println("Interfaces are: " + Arrays.toString(cl.getInterfaces()));
//
//        System.out.println("Access modifiers: " + Modifier.toString(cl.getModifiers()));
//
//        // only returns public fields
//        System.out.println("Fields: " + Arrays.toString(cl.getFields()));
//        System.out.println("Declared  fields: " + Arrays.toString(cl.getDeclaredFields()));
//
        System.out.println("Constructors: " + Arrays.toString(cl.getConstructors()));
        System.out.println("Declared constructors: " + Arrays.toString(cl.getDeclaredConstructors()));


        System.out.println("Methods: " + Arrays.toString(cl.getMethods()));
        System.out.println("Declared methods: " + Arrays.toString(cl.getDeclaredMethods()));

        System.out.println("Annotations: " + Arrays.toString(cl.getAnnotations()));
        System.out.println("Declared annotations: " + Arrays.toString(cl.getDeclaredAnnotations()));

        Child ch = new Child("Jubaer", 3);
        ch.doNotUseIt();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // initial();
        metadata();
    }
}
