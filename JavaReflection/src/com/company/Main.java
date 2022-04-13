package com.company;

import java.lang.reflect.*;
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

    private static void invokePrivateMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cl = Class.forName("com.company.Welcome");
        Method method = cl.getDeclaredMethod("greet", String.class);
        method.setAccessible(true);
        Object object = method.invoke(new Welcome(), "Jubaer");
        String message = (String) object;
        System.out.println("Greeting: " + message);
    }

    private static void invokePrivateVariable() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class<?> cl = Class.forName("com.company.Welcome1");
        Field field = cl.getDeclaredField("message");
        field.setAccessible(true);
        Object object = field.get(new Welcome1());
        String message = (String) object;
        System.out.println("The message is: " + message);
    }

    private static void aboutConstructor() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> cl = Class.forName("com.company.TestClass");

//        System.out.println("Constructors: " + Arrays.toString(cl.getConstructors()));
//        Constructor<?> constructor = cl.getConstructor(int.class, String.class);
//        System.out.println("Constructors: " + constructor.toString());
//
//        Constructor<?> declaredConstructor = cl.getDeclaredConstructor();
//        System.out.println("Declared Constructor: " + declaredConstructor.toString());

        System.out.println("Declared Constructors: " + Arrays.toString(cl.getDeclaredConstructors()));

    }

    private static void createInstance() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> cl = Class.forName("com.company.TestClass");

        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for(Constructor<?> con: constructors) {
            System.out.println("Constructor: " + con.getName());
            TestClass testClass;
            if(Modifier.toString(con.getModifiers()).equals("private")) {
                con.setAccessible(true);
                testClass = (TestClass) con.newInstance();
            }
            else {
                testClass = (TestClass) con.newInstance(200, "public");
            }
            testClass.showValue();
        }
    }

    private static void identifyArray() throws ClassNotFoundException {
        Class<?> cl = Class.forName("com.company.Employee");

        Field[] fields = cl.getDeclaredFields();
        for(Field field: fields) {
            Class<?> type = field.getType();
            if(type.isArray()) {
                System.out.println("Array found: " + field.getName());
            }
        }

        // declare array using reflection
        double[] doubleArray = (double[]) Array.newInstance(double.class, 5);
        System.out.println("Array length: " + doubleArray.length);

        // set elements
        Array.setDouble(doubleArray, 0, 1.0);
        Array.setDouble(doubleArray, 1, 2.0);
        Array.setDouble(doubleArray, 2, 3.0);
        Array.setDouble(doubleArray, 3, 4.0);
        Array.setDouble(doubleArray, 4, 5.0);

        System.out.println("First element: " + Array.get(doubleArray, 0));
        System.out.println("Third element: " + Array.get(doubleArray, 2));
        System.out.println("Fifth element: " + Array.get(doubleArray, 4));
    }

    public static void getterAndSetter() throws ClassNotFoundException {
        Class<?> cl = Class.forName("com.company.GetSet");

        Field[] fields = cl.getDeclaredFields();
        System.out.println("Fields: " + Arrays.toString(fields));


        StringBuffer stringBuffer = new StringBuffer();
        for(Field field: fields) {
            String fieldName = field.getName();
            String fieldType = field.getType().getSimpleName();

            System.out.println("Field name: " + fieldName);
            System.out.println("Field type: " + fieldType);

            CommonUtil.createSetter(fieldName, fieldType, stringBuffer);
            CommonUtil.createGetter(fieldName, fieldType, stringBuffer);
        }

        System.out.println(stringBuffer);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        // Temp temp = new Temp();

        // initial();
        // metadata();
        // invokePrivateMethod();
        // invokePrivateVariable();
        // aboutConstructor();
        // createInstance();
        // identifyArray();
        getterAndSetter();
    }
}
