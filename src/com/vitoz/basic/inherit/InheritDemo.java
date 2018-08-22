package com.vitoz.basic.inherit;

public class InheritDemo {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println("Child Print ------------------------------------");
        System.out.println(child.getVersionID());
        System.out.println(child.name);
        System.out.println(Child.type);
        child.printName();
        Child.printType();

        Father father = child;
        System.out.println("Father Print ------------------------------------");
        System.out.println(father.getVersionID());
        System.out.println(father.name);
        System.out.println(Father.type);
        father.printName();
        Father.printType();

        Child newChild = (Child)father;
        System.out.println("Child Print Again------------------------------------");
        System.out.println(newChild.getVersionID());
        System.out.println(newChild.name);
        System.out.println(Child.type);
        newChild.printName();
        Child.printType();
    }
}

class Father{
    private String versionID = "12345";
    public String name = "father";
    public static String type = "human being father";

    public String getVersionID() {
        return versionID;
    }

    public void printName(){
        System.out.println("I am the "+name);
    }

    public static void printType(){
        System.out.println("I am one of the "+type);
    }
}

class Child extends Father{
    private String versionID = "67890";
    public String name = "child";
    public static String type = "human being child";

    @Override
    public String getVersionID() {
        return versionID;
    }

    @Override
    public void printName(){
        System.out.println("I am just a "+name);
    }

    public static void printType(){
        System.out.println("I am just a "+type);
    }
}